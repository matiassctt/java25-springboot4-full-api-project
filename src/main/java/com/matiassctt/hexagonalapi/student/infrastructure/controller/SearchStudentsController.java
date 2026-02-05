package com.matiassctt.hexagonalapi.student.infrastructure.controller;

import com.matiassctt.hexagonalapi.shared.infrastructure.model.request.PaginationRequest;
import com.matiassctt.hexagonalapi.shared.domain.pagination.Pagination;
import com.matiassctt.hexagonalapi.student.application.SearchStudentsByFiltersUseCase;
import com.matiassctt.hexagonalapi.student.domain.Student;
import com.matiassctt.hexagonalapi.student.domain.StudentSearchCriteria;
import com.matiassctt.hexagonalapi.student.infrastructure.mapper.StudentToStudentResponseMapper;
import com.matiassctt.hexagonalapi.student.infrastructure.model.enums.StudentSortField;
import com.matiassctt.hexagonalapi.student.infrastructure.model.request.StudentsFilters;
import com.matiassctt.hexagonalapi.student.infrastructure.model.response.StudentResponse;
import com.matiassctt.hexagonalapi.shared.infrastructure.model.enums.SortDirection;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/students")
public class SearchStudentsController {

    private final SearchStudentsByFiltersUseCase searchStudentsUseCase;

    public SearchStudentsController(SearchStudentsByFiltersUseCase searchStudentsUseCase) {
        this.searchStudentsUseCase = searchStudentsUseCase;
    }

    @GetMapping
    public ResponseEntity<Pagination<StudentResponse>> search(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size,
            @RequestParam(defaultValue = "id") StudentSortField sortBy,
            @RequestParam(defaultValue = "ASC") SortDirection direction,
            @RequestParam(required = false) String name,
            @RequestParam(required = false) Boolean active
    ) {
        PaginationRequest pagination = new PaginationRequest(page, size, sortBy.column(), direction);

        StudentsFilters filters = new StudentsFilters(
                Optional.ofNullable(name),
                Optional.ofNullable(active)
        );

        StudentSearchCriteria criteria = new StudentSearchCriteria(filters.name(), filters.active());

        Pagination<Student> result = searchStudentsUseCase.execute(pagination, criteria);

        Pagination<StudentResponse> response = Pagination.from(result, StudentToStudentResponseMapper::fromDomain);

        return ResponseEntity.ok(response);
    }
}

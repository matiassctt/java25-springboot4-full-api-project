package com.matiassctt.hexagonalapi.student.infrastructure.controller;

import com.matiassctt.hexagonalapi.shared.pagination.Pagination;
import com.matiassctt.hexagonalapi.student.application.SearchStudentsUseCase;
import com.matiassctt.hexagonalapi.student.domain.Student;
import com.matiassctt.hexagonalapi.student.infrastructure.mapper.StudentToStudentResponseMapper;
import com.matiassctt.hexagonalapi.student.infrastructure.model.request.SearchStudentsRequest;
import com.matiassctt.hexagonalapi.student.infrastructure.model.response.StudentResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/students")
public class SearchStudentsController {

    private final SearchStudentsUseCase searchStudentsUseCase;

    public SearchStudentsController(SearchStudentsUseCase searchStudentsUseCase) {
        this.searchStudentsUseCase = searchStudentsUseCase;
    }

    @GetMapping
    public ResponseEntity<Pagination<StudentResponse>> search(@RequestParam SearchStudentsRequest request) {
        Pagination<Student> result = searchStudentsUseCase.execute(request.page(), request.size());

        Pagination<StudentResponse> response =
                Pagination.from(
                        result,
                        StudentToStudentResponseMapper::fromDomain
                );

        return ResponseEntity.ok(response);
    }

}

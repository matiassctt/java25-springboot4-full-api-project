package com.matiassctt.hexagonalapi.student.application;

import com.matiassctt.hexagonalapi.shared.domain.pagination.Pagination;
import com.matiassctt.hexagonalapi.shared.infrastructure.model.request.PaginationRequest;
import com.matiassctt.hexagonalapi.student.domain.Student;
import com.matiassctt.hexagonalapi.student.domain.StudentRepository;
import com.matiassctt.hexagonalapi.student.domain.StudentSearchCriteria;

public class SearchStudentsByFiltersUseCase {

    private final StudentRepository repository;

    public SearchStudentsByFiltersUseCase(StudentRepository repository) {
        this.repository = repository;
    }

    public Pagination<Student> execute(PaginationRequest paginationRequest, StudentSearchCriteria criteria) {
        return repository.searchByFilter(paginationRequest, criteria);
    }
}

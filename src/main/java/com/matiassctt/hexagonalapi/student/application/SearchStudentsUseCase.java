package com.matiassctt.hexagonalapi.student.application;

import com.matiassctt.hexagonalapi.shared.infrastructure.model.response.PaginationResponse;
import com.matiassctt.hexagonalapi.shared.infrastructure.model.request.PaginationRequest;
import com.matiassctt.hexagonalapi.student.domain.Student;
import com.matiassctt.hexagonalapi.student.domain.StudentRepository;
import com.matiassctt.hexagonalapi.student.domain.StudentSearchCriteria;

import java.util.List;

public class SearchStudentsUseCase {

    private final StudentRepository repository;

    public SearchStudentsUseCase(StudentRepository repository) {
        this.repository = repository;
    }

    public PaginationResponse<Student> execute(PaginationRequest paginationRequest, StudentSearchCriteria criteria) {
        return repository.search(paginationRequest, criteria);
    }
}

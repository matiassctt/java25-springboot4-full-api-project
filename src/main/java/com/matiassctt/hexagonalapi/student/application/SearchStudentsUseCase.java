package com.matiassctt.hexagonalapi.student.application;

import com.matiassctt.hexagonalapi.shared.pagination.Pagination;
import com.matiassctt.hexagonalapi.student.domain.Student;
import com.matiassctt.hexagonalapi.student.domain.StudentRepository;

import java.util.List;

public class SearchStudentsUseCase {

    private final StudentRepository repository;

    public SearchStudentsUseCase(StudentRepository repository) {
        this.repository = repository;
    }

    public Pagination<Student> execute(int page, int size) {
        return repository.search(page, size);
    }
}

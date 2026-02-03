package com.matiassctt.hexagonalapi.student.application;

import com.matiassctt.hexagonalapi.student.domain.Student;
import com.matiassctt.hexagonalapi.student.domain.StudentRepository;

import java.util.Optional;

public class FindStudentUseCase {

    private final StudentRepository repository;

    public FindStudentUseCase(StudentRepository repository) {
        this.repository = repository;
    }

    public Optional<Student> execute(Long id) {
        return repository.findById(id);
    }
}

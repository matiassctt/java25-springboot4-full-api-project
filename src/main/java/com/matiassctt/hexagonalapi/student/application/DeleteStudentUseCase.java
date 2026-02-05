package com.matiassctt.hexagonalapi.student.application;

import com.matiassctt.hexagonalapi.student.application.exception.StudentNotFoundException;
import com.matiassctt.hexagonalapi.student.domain.Student;
import com.matiassctt.hexagonalapi.student.domain.StudentRepository;

public class DeleteStudentUseCase {

    private final StudentRepository repository;

    public DeleteStudentUseCase(StudentRepository repository) {
        this.repository = repository;
    }

    public void execute(Long id) {
        Student student = repository.findById(id).orElseThrow(() -> new StudentNotFoundException(id));
        repository.delete(student);
    }
}

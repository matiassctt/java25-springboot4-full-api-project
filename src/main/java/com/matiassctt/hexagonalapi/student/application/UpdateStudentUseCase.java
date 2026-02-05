package com.matiassctt.hexagonalapi.student.application;

import com.matiassctt.hexagonalapi.student.application.exception.StudentNotFoundException;
import com.matiassctt.hexagonalapi.student.domain.Student;
import com.matiassctt.hexagonalapi.student.domain.StudentRepository;

public class UpdateStudentUseCase {

    private final StudentRepository repository;

    public UpdateStudentUseCase(StudentRepository repository) {
        this.repository = repository;
    }

    public Student execute(Long id, String name, Boolean active) {
        Student student = repository.findById(id).orElseThrow(() -> new StudentNotFoundException(id));

        Student updated = student.update(name, active);

        return repository.save(updated);
    }
}

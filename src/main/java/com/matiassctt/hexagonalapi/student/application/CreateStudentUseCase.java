package com.matiassctt.hexagonalapi.student.application;

import com.matiassctt.hexagonalapi.student.domain.Student;
import com.matiassctt.hexagonalapi.student.domain.StudentRepository;

public class CreateStudentUseCase {

    private final StudentRepository repository;

    public CreateStudentUseCase(StudentRepository repository) {
        this.repository = repository;
    }

    public Student execute(String name, Boolean active) {
        Student student = new Student(null, name, active);
        return repository.save(student);
    }
}

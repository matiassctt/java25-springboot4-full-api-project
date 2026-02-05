package com.matiassctt.hexagonalapi.student.application.exception;

public class StudentNotFoundException extends RuntimeException {

    public StudentNotFoundException(Long id) {
        super("Student not found with id " + id);
    }
}
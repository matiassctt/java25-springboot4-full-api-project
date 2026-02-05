package com.matiassctt.hexagonalapi.student.domain.exception;

public class StudentParameterIsRequiredException extends RuntimeException {

    public StudentParameterIsRequiredException(String parameterName) {
        super("Parameter " + parameterName + " is required");
    }
}
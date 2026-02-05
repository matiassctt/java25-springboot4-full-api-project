package com.matiassctt.hexagonalapi.student.infrastructure.exception;

import com.matiassctt.hexagonalapi.shared.infrastructure.model.response.ExceptionResponse;
import com.matiassctt.hexagonalapi.student.application.exception.StudentNotFoundException;
import com.matiassctt.hexagonalapi.student.domain.exception.StudentParameterIsRequiredException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class StudentExceptionHandler {

    @ExceptionHandler(StudentNotFoundException.class)
    public ResponseEntity<ExceptionResponse> handleStudentNotFound(StudentNotFoundException ex) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ExceptionResponse(ex.getMessage()));
    }

    @ExceptionHandler(StudentParameterIsRequiredException.class)
    public ResponseEntity<ExceptionResponse> handleStudentParameterIsInvalid(StudentParameterIsRequiredException ex) {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new ExceptionResponse(ex.getMessage()));
    }
}
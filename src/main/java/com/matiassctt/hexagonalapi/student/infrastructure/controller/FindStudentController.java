package com.matiassctt.hexagonalapi.student.infrastructure.controller;

import com.matiassctt.hexagonalapi.student.application.FindStudentUseCase;
import com.matiassctt.hexagonalapi.student.infrastructure.mapper.StudentToStudentResponseMapper;
import com.matiassctt.hexagonalapi.student.infrastructure.model.response.StudentResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/students")
public class FindStudentController {

    private final FindStudentUseCase findStudentUseCase;

    public FindStudentController(FindStudentUseCase findStudentUseCase) {
        this.findStudentUseCase = findStudentUseCase;
    }

    @GetMapping("/{id}")
    public ResponseEntity<StudentResponse> findById(@PathVariable Long id) {
        return findStudentUseCase.execute(id)
                .map(StudentToStudentResponseMapper::fromDomain)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }
}

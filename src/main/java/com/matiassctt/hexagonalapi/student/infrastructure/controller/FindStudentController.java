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
        StudentResponse response =
                StudentToStudentResponseMapper.fromDomain(
                        findStudentUseCase.execute(id)
                );

        return ResponseEntity.ok(response);
    }
}

package com.matiassctt.hexagonalapi.student.infrastructure.controller;

import com.matiassctt.hexagonalapi.student.application.UpdateStudentUseCase;
import com.matiassctt.hexagonalapi.student.infrastructure.mapper.StudentToStudentResponseMapper;
import com.matiassctt.hexagonalapi.student.infrastructure.model.request.UpdateStudentRequest;
import com.matiassctt.hexagonalapi.student.infrastructure.model.response.StudentResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/students")
public class UpdateStudentController {

    private final UpdateStudentUseCase updateStudentUseCase;

    public UpdateStudentController(UpdateStudentUseCase updateStudentUseCase) {
        this.updateStudentUseCase = updateStudentUseCase;
    }

    @PutMapping("/{id}")
    public ResponseEntity<StudentResponse> create(@PathVariable Long id, @RequestBody UpdateStudentRequest request) {
        StudentResponse response =
                StudentToStudentResponseMapper.fromDomain(
                        updateStudentUseCase.execute(id, request.name(), request.active())
                );

        return ResponseEntity.ok(response);
    }
}

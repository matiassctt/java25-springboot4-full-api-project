package com.matiassctt.hexagonalapi.student.infrastructure.controller;

import com.matiassctt.hexagonalapi.student.application.CreateStudentUseCase;
import com.matiassctt.hexagonalapi.student.infrastructure.mapper.StudentToStudentResponseMapper;
import com.matiassctt.hexagonalapi.student.infrastructure.model.request.CreateStudentRequest;
import com.matiassctt.hexagonalapi.student.infrastructure.model.response.StudentResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/students")
public class CreateStudentController {

    private final CreateStudentUseCase createStudentUseCase;

    public CreateStudentController(CreateStudentUseCase createStudentUseCase) {
        this.createStudentUseCase = createStudentUseCase;
    }

    @PostMapping
    public ResponseEntity<StudentResponse> create(@RequestBody CreateStudentRequest request) {
        StudentResponse response =
                StudentToStudentResponseMapper.fromDomain(
                        createStudentUseCase.execute(request.name(), request.active())
                );

        return ResponseEntity.ok(response);
    }
}

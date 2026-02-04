package com.matiassctt.hexagonalapi.student.infrastructure.controller;

import com.matiassctt.hexagonalapi.student.application.CreateStudentUseCase;
import com.matiassctt.hexagonalapi.student.domain.Student;
import com.matiassctt.hexagonalapi.student.infrastructure.model.request.CreateStudentRequest;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/students")
public class CreateStudentController {

    private final CreateStudentUseCase createStudentUseCase;

    public CreateStudentController(CreateStudentUseCase createStudentUseCase) {
        this.createStudentUseCase = createStudentUseCase;
    }

    @PostMapping
    public Student create(@RequestBody CreateStudentRequest request) {
        return createStudentUseCase.execute(request.name(), request.active());
    }
}

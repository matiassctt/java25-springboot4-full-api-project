package com.matiassctt.hexagonalapi.student.infrastructure.controller;

import com.matiassctt.hexagonalapi.student.application.DeleteStudentUseCase;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/students")
public class DeleteStudentController {

    private final DeleteStudentUseCase deleteStudentUseCase;

    public DeleteStudentController(DeleteStudentUseCase deleteStudentUseCase) {
        this.deleteStudentUseCase = deleteStudentUseCase;
    }

    @DeleteMapping("/{id}")
    public void update(@PathVariable Long id) {
        deleteStudentUseCase.execute(id);
    }
}

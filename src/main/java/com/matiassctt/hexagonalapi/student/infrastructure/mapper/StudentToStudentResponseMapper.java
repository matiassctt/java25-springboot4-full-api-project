package com.matiassctt.hexagonalapi.student.infrastructure.mapper;

import com.matiassctt.hexagonalapi.student.domain.Student;
import com.matiassctt.hexagonalapi.student.infrastructure.model.response.StudentResponse;

public final class StudentToStudentResponseMapper {

    private StudentToStudentResponseMapper() {
    }

    public static StudentResponse fromDomain(Student student) {
        return new StudentResponse(student.getId(), student.getName(), student.getActive());
    }
}

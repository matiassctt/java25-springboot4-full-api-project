package com.matiassctt.hexagonalapi.student;

import java.util.Random;
import com.matiassctt.hexagonalapi.student.domain.Student;

public class StudentFixture {
    private static final Random RANDOM = new Random(123);

    public static Student validStudent() {
        return new Student(1L, "Matias", true);
    }

    public static Student validStudentWithoutId() {
        return new Student(null, "Matias", true);
    }
}


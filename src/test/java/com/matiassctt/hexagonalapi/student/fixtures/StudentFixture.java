package com.matiassctt.hexagonalapi.student.fixtures;

import java.util.Random;
import com.matiassctt.hexagonalapi.student.domain.Student;

public class StudentFixture {
    private static final Random RANDOM = new Random(123);

    public static Student newStudent() {
        return new Student(null, "Matias", true);
    }

    public static Student validStudent() {
        return new Student(1L, "Matias", true);
    }

    public static Student validStudentWithoutId() {
        return new Student(null, "Matias", true);
    }

    public static StudentBuilder aStudent() {
        return new StudentBuilder();
    }

    public static class StudentBuilder {
        private Long id = 1L;
        private String name = "Student";
        private Boolean active = true;

        public StudentBuilder withId(Long id) {
            this.id = id;
            return this;
        }

        public StudentBuilder withName(String name) {
            this.name = name;
            return this;
        }

        public StudentBuilder withActive(boolean active) {
            this.active = active;
            return this;
        }

        public Student build() {
            return new Student(id, name, active);
        }
    }

}


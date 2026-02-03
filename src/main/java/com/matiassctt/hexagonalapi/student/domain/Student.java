package com.matiassctt.hexagonalapi.student.domain;

public class Student {

    private final Long id;
    private final String name;

    public Student(Long id, String name) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("Student name cannot be empty");
        }
        this.id = id;
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}

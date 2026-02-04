package com.matiassctt.hexagonalapi.student.domain;

public class Student {

    private final Long id;
    private final String name;
    private final Boolean active;

    public Student(Long id, String name, Boolean active) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("Student name cannot be empty");
        }
        this.id = id;
        this.name = name;
        this.active = active;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Boolean getActive() {
        return active;
    }
}

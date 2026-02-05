package com.matiassctt.hexagonalapi.student.domain;

import com.matiassctt.hexagonalapi.student.domain.exception.StudentParameterIsRequiredException;

public class Student {

    private final Long id;
    private final String name;
    private final Boolean active;

    public Student(Long id, String name, Boolean active) {
        if (name == null || name.isBlank()) {
            throw new StudentParameterIsRequiredException("name");
        }

        if (active == null) {
            throw new StudentParameterIsRequiredException("active");
        }

        this.id = id;
        this.name = name;
        this.active = active;
    }

    public Student update(String name, Boolean active) {
        return new Student(this.id, name, active);
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

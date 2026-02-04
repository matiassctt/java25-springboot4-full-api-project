package com.matiassctt.hexagonalapi.student.infrastructure.persistence;

import jakarta.persistence.*;
import com.matiassctt.hexagonalapi.student.domain.Student;

@Entity
@Table(name = "students")
public class StudentEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private Boolean active;

    protected StudentEntity() {}

    public StudentEntity(Long id, String name, Boolean active) {
        this.id = id;
        this.name = name;
        this.active = active;
    }

    public static StudentEntity fromDomain(Student student) {
        return new StudentEntity(student.getId(), student.getName(), student.getActive());
    }

    public Student toDomain() {
        return new Student(id, name, active);
    }
}

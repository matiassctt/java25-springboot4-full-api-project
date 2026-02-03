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

    protected StudentEntity() {}

    public StudentEntity(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public static StudentEntity fromDomain(Student student) {
        return new StudentEntity(student.getId(), student.getName());
    }

    public Student toDomain() {
        return new Student(id, name);
    }
}

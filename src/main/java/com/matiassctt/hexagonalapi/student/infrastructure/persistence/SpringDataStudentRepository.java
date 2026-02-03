package com.matiassctt.hexagonalapi.student.infrastructure.persistence;

import org.springframework.data.jpa.repository.JpaRepository;

public interface SpringDataStudentRepository
        extends JpaRepository<StudentEntity, Long> {
}
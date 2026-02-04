package com.matiassctt.hexagonalapi.student.infrastructure.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface SpringDataStudentRepository extends JpaRepository<StudentEntity, Long>, JpaSpecificationExecutor<StudentEntity>
{ }
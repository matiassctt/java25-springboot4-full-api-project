package com.matiassctt.hexagonalapi.student.infrastructure.persistence;

import com.matiassctt.hexagonalapi.student.domain.Student;
import com.matiassctt.hexagonalapi.student.fixtures.StudentFixture;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.data.jpa.test.autoconfigure.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DataJpaTest
@ActiveProfiles("test")
class SpringDataStudentRepositoryTest {

    @Autowired
    private SpringDataStudentRepository repository;

    @Test
    void should_save_a_new_student_entity() {
        Student domain = StudentFixture.newStudent();
        StudentEntity entity = StudentEntity.fromDomain(domain);

        StudentEntity saved = repository.save(entity);

        Student result = saved.toDomain();

        assertEquals(domain.getName(), result.getName());
        assertEquals(domain.getActive(), result.getActive());
    }
}

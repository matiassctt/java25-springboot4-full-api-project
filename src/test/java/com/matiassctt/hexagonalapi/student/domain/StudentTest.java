package com.matiassctt.hexagonalapi.student.domain;

import com.matiassctt.hexagonalapi.student.domain.exception.StudentParameterIsRequiredException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StudentTest {

    @Test
    void should_create_student_when_data_is_valid() {
        Student student = new Student(1L, "Matias", true);

        assertNotNull(student);
        assertEquals(1L, student.getId());
        assertEquals("Matias", student.getName());
        assertTrue(student.getActive());
    }

    @Test
    void should_throw_exception_when_name_is_null() {
        StudentParameterIsRequiredException exception =
                assertThrows(StudentParameterIsRequiredException.class,
                        () -> new Student(1L, null, true));

        assertEquals("Parameter name is required", exception.getMessage());
    }

    @Test
    void should_throw_exception_when_name_is_blank() {
        assertThrows(StudentParameterIsRequiredException.class, () -> new Student(1L, "   ", true));
    }

    @Test
    void should_throw_exception_when_active_is_null() {
        StudentParameterIsRequiredException exception =
                assertThrows(StudentParameterIsRequiredException.class,
                        () -> new Student(1L, "Matias", null));

        assertEquals("Parameter active is required", exception.getMessage());
    }
}
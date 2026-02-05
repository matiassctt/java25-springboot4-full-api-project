package com.matiassctt.hexagonalapi.student.application;

import com.matiassctt.hexagonalapi.student.fixtures.StudentFixture;
import com.matiassctt.hexagonalapi.student.domain.Student;
import com.matiassctt.hexagonalapi.student.domain.StudentRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class CreateStudentUseCaseTest {

    @Mock
    private StudentRepository repository;

    @InjectMocks
    private CreateStudentUseCase useCase;

    @Test
    void should_create_student_successfully() {
        Student student = StudentFixture.validStudentWithoutId();

        when(repository.save(any(Student.class))).thenReturn(StudentFixture.validStudent());

        Student result = useCase.execute(student.getName(), student.getActive());

        assertNotNull(result.getId());
        assertEquals("Matias", result.getName());
        assertTrue(result.getActive());

        verify(repository).save(any(Student.class));
    }
}

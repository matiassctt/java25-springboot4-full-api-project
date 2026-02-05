package com.matiassctt.hexagonalapi.student.application;

import com.matiassctt.hexagonalapi.student.fixtures.StudentFixture;
import com.matiassctt.hexagonalapi.student.application.exception.StudentNotFoundException;
import com.matiassctt.hexagonalapi.student.domain.Student;
import com.matiassctt.hexagonalapi.student.domain.StudentRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
@ExtendWith(MockitoExtension.class)
class FindStudentUseCaseTest {

    @Mock
    private StudentRepository repository;

    @InjectMocks
    private FindStudentUseCase useCase;

    @Test
    void should_find_a_student_successfully() {
        Student student = StudentFixture.validStudent();

        when(repository.findById(student.getId()))
                .thenReturn(Optional.of(student));

        Student result = useCase.execute(student.getId());

        assertEquals(student.getId(), result.getId());
        assertEquals(student.getName(), result.getName());
        assertEquals(student.getActive(), result.getActive());

        verify(repository).findById(student.getId());
    }

    @Test
    void should_throw_exception_when_student_not_found() {
        Long id = 1L;

        when(repository.findById(id)).thenReturn(Optional.empty());

        assertThrows(StudentNotFoundException.class, () -> useCase.execute(id));

        verify(repository).findById(id);
    }
}

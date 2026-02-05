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

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class DeleteStudentUseCaseTest {

    @Mock
    private StudentRepository repository;

    @InjectMocks
    private DeleteStudentUseCase useCase;

    @Test
    void should_delete_a_student_successfully() {
        Student student = StudentFixture.validStudent();

        when(repository.findById(student.getId())).thenReturn(Optional.of(student));

        useCase.execute(student.getId());

        verify(repository).findById(student.getId());
        verify(repository).delete(student);
    }

    @Test
    void should_throw_exception_when_student_not_found_while_deleting() {
        Long id = 1L;

        when(repository.findById(id)).thenReturn(Optional.empty());

        assertThrows(StudentNotFoundException.class, () -> useCase.execute(id));

        verify(repository).findById(id);
        verify(repository, never()).delete(any());
    }
}

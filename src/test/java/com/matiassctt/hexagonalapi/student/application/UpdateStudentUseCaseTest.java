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
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class UpdateStudentUseCaseTest {

    @Mock
    private StudentRepository repository;

    @InjectMocks
    private UpdateStudentUseCase useCase;

    @Test
    void should_update_a_student_successfully() {
        Student student = StudentFixture.validStudent();
        String newName = "Juan";
        Boolean newActive = false;

        Student updatedStudent = StudentFixture.aStudent()
                .withName(newName)
                .withActive(newActive)
                .build();

        when(repository.findById(student.getId())).thenReturn(Optional.of(student));
        when(repository.save(any(Student.class))).thenReturn(updatedStudent);

        Student result = useCase.execute(student.getId(), newName, newActive);

        assertEquals(newName, result.getName());
        assertEquals(newActive, result.getActive());

        verify(repository).findById(student.getId());
        verify(repository).save(any(Student.class));
    }

    @Test
    void should_throw_exception_when_student_not_found_while_updating() {
        Long id = 1L;

        when(repository.findById(id))
                .thenReturn(Optional.empty());

        assertThrows(StudentNotFoundException.class,
                () -> useCase.execute(id, "Juan", false));

        verify(repository).findById(id);
        verify(repository, never()).save(any());
    }
}

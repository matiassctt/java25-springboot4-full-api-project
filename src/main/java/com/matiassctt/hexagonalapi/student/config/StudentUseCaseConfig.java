package com.matiassctt.hexagonalapi.student.config;

import com.matiassctt.hexagonalapi.student.application.*;
import com.matiassctt.hexagonalapi.student.domain.StudentRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class StudentUseCaseConfig {

    @Bean
    CreateStudentUseCase createStudentUseCase(StudentRepository repo) {
        return new CreateStudentUseCase(repo);
    }

    @Bean
    UpdateStudentUseCase updateStudentUseCase(StudentRepository repo) {
        return new UpdateStudentUseCase(repo);
    }

    @Bean
    FindStudentUseCase findStudentUseCase(StudentRepository repo) {
        return new FindStudentUseCase(repo);
    }

    @Bean
    SearchStudentsUseCase searchStudentsUseCase(StudentRepository repo) {
        return new SearchStudentsUseCase(repo);
    }

    @Bean
    DeleteStudentUseCase deleteStudentUseCase(StudentRepository repo) {
        return new DeleteStudentUseCase(repo);
    }
}

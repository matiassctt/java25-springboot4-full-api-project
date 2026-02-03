package com.matiassctt.hexagonalapi.student.infrastructure.persistence;

import com.matiassctt.hexagonalapi.shared.pagination.Pagination;
import com.matiassctt.hexagonalapi.student.domain.Student;
import com.matiassctt.hexagonalapi.student.domain.StudentRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class JpaStudentRepository implements StudentRepository {

    private final SpringDataStudentRepository jpaRepository;

    public JpaStudentRepository(SpringDataStudentRepository jpaRepository) {
        this.jpaRepository = jpaRepository;
    }

    @Override
    public Student save(Student student) {
        StudentEntity entity = StudentEntity.fromDomain(student);
        return jpaRepository.save(entity).toDomain();
    }

    @Override
    public Optional<Student> findById(Long id) {
        return jpaRepository.findById(id).map(StudentEntity::toDomain);
    }

    @Override
    public Pagination<Student> search(int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        Page<StudentEntity> pageResult = jpaRepository.findAll(pageable);

        return new Pagination<>(
                pageResult.getContent()
                        .stream()
                        .map(StudentEntity::toDomain)
                        .toList(),
                pageResult.getTotalElements(),
                pageResult.getNumber(),
                pageResult.getTotalPages()
        );
    }

}

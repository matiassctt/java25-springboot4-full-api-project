package com.matiassctt.hexagonalapi.student.infrastructure.persistence;

import com.matiassctt.hexagonalapi.shared.infrastructure.model.enums.SortDirection;
import com.matiassctt.hexagonalapi.shared.infrastructure.model.response.PaginationResponse;
import com.matiassctt.hexagonalapi.shared.infrastructure.model.request.PaginationRequest;
import com.matiassctt.hexagonalapi.student.domain.StudentSearchCriteria;
import org.springframework.data.jpa.domain.Specification;
import com.matiassctt.hexagonalapi.student.domain.Student;
import com.matiassctt.hexagonalapi.student.domain.StudentRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
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
    public PaginationResponse<Student> search(
            PaginationRequest pagination,
            StudentSearchCriteria criteria
    ) {
        Sort sort = Sort.by(
                pagination.direction() == SortDirection.ASC ? Sort.Direction.ASC : Sort.Direction.DESC,
                pagination.sortBy()
        );

        Pageable pageable = PageRequest.of(pagination.page(), pagination.size(), sort);

        Specification<StudentEntity> spec =
                Specification.where(
                        StudentSpecifications.withName(criteria.name())
                ).and(
                        StudentSpecifications.withActive(criteria.active())
                );


        Page<StudentEntity> pageResult = jpaRepository.findAll(spec, pageable);

        return new PaginationResponse<>(
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

package com.matiassctt.hexagonalapi.student.domain;

import com.matiassctt.hexagonalapi.shared.domain.pagination.Pagination;
import com.matiassctt.hexagonalapi.shared.infrastructure.model.request.PaginationRequest;
import java.util.Optional;

public interface StudentRepository {

    Student save(Student student);

    Optional<Student> findById(Long id);

    Pagination<Student> searchByFilter(PaginationRequest paginationRequest, StudentSearchCriteria criteria);

    void delete(Student student);
}

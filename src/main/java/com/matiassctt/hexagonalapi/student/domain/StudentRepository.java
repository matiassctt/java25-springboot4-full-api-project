package com.matiassctt.hexagonalapi.student.domain;

import com.matiassctt.hexagonalapi.shared.infrastructure.model.response.PaginationResponse;
import com.matiassctt.hexagonalapi.shared.infrastructure.model.request.PaginationRequest;
import java.util.Optional;

public interface StudentRepository {

    Student save(Student student);

    Optional<Student> findById(Long id);

    PaginationResponse<Student> search(PaginationRequest paginationRequest, StudentSearchCriteria criteria);
}

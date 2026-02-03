package com.matiassctt.hexagonalapi.student.domain;

import com.matiassctt.hexagonalapi.shared.pagination.Pagination;
import java.util.Optional;

public interface StudentRepository {

    Student save(Student student);

    Optional<Student> findById(Long id);

    Pagination<Student> search(int page, int size);
}

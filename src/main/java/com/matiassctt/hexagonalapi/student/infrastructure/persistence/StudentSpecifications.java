package com.matiassctt.hexagonalapi.student.infrastructure.persistence;

import org.springframework.data.jpa.domain.Specification;

import java.util.Optional;

public final class StudentSpecifications {

    private StudentSpecifications() {}

    public static Specification<StudentEntity> withName(Optional<String> name) {
        return (root, query, cb) ->
                name.map(n ->
                        cb.like(
                                cb.lower(root.get("name")),
                                "%" + n.toLowerCase() + "%"
                        )
                ).orElse(cb.conjunction());
    }

    public static Specification<StudentEntity> withActive(Optional<Boolean> active) {
        return (root, query, cb) ->
                active
                        .map(value -> cb.equal(root.get("active"), value))
                        .orElse(cb.conjunction());
    }

}

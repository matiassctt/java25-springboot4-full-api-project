package com.matiassctt.hexagonalapi.student.infrastructure.model.request;

import java.util.Optional;

public record StudentsFilters(
        Optional<String> name,
        Optional<Boolean> active
) {}
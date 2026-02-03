package com.matiassctt.hexagonalapi.student.infrastructure.model.request;

import java.util.Optional;

public record SearchStudentsRequest(
        int page,
        int size,
        Optional<String> name
) {}
package com.matiassctt.hexagonalapi.student.domain;

import java.util.Optional;

public record StudentSearchCriteria(
        Optional<String> name,
        Optional<Boolean> active
) {}

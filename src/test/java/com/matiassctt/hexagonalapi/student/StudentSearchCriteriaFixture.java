package com.matiassctt.hexagonalapi.student;

import java.util.Optional;
import com.matiassctt.hexagonalapi.student.domain.StudentSearchCriteria;

public class StudentSearchCriteriaFixture {
    public static StudentSearchCriteria withFilters() {
        return new StudentSearchCriteria(Optional.of("Matias"), Optional.of(true));
    }

    public static StudentSearchCriteria withoutFilters() {
        return new StudentSearchCriteria(Optional.empty(), Optional.empty());
    }
}


package com.matiassctt.hexagonalapi.shared.infrastructure.model.request;

import com.matiassctt.hexagonalapi.shared.infrastructure.model.enums.SortDirection;

public record PaginationRequest(
        int page,
        int size,
        String sortBy,
        SortDirection direction
) {
    public static PaginationRequest defaultRequest() {
        return new PaginationRequest(0, 10, "id", SortDirection.ASC);
    }
}

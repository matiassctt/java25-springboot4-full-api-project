package com.matiassctt.hexagonalapi.shared.model.request;

import com.matiassctt.hexagonalapi.shared.infrastructure.model.enums.SortDirection;
import com.matiassctt.hexagonalapi.shared.infrastructure.model.request.PaginationRequest;

public class PaginationRequestFixture {
    public static PaginationRequest defaultSortASC() {
        return new PaginationRequest(0, 10, "id", SortDirection.ASC);
    }
}


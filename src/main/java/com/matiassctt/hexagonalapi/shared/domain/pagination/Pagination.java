package com.matiassctt.hexagonalapi.shared.domain.pagination;

import java.util.List;
import java.util.function.Function;

public class Pagination<T> {

    private final List<T> items;
    private final long totalItems;
    private final int page;
    private final int totalPages;

    public Pagination(
            List<T> items,
            long totalItems,
            int page,
            int totalPages
    ) {
        this.items = items;
        this.totalItems = totalItems;
        this.page = page;
        this.totalPages = totalPages;
    }

    public static <D, R> Pagination<R> from(
            Pagination<D> result,
            Function<D, R> mapper
    ) {
        return new Pagination<>(
                result.getItems().stream().map(mapper).toList(),
                result.getTotalItems(),
                result.getPage(),
                result.getTotalPages()
        );
    }

    public List<T> getItems() {
        return items;
    }

    public long getTotalItems() {
        return totalItems;
    }

    public int getPage() {
        return page;
    }

    public int getTotalPages() {
        return totalPages;
    }
}

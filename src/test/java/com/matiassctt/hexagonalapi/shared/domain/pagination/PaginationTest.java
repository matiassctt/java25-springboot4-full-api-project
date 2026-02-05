package com.matiassctt.hexagonalapi.shared.domain.pagination;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class PaginationTest {

    @Test
    void should_create_pagination_correctly() {
        List<String> items = List.of("a", "b", "c");

        Pagination<String> pagination = new Pagination<>(
                items,
                10,
                1,
                4
        );

        assertEquals(items, pagination.getItems());
        assertEquals(10, pagination.getTotalItems());
        assertEquals(1, pagination.getPage());
        assertEquals(4, pagination.getTotalPages());
    }

    @Test
    void should_map_items_using_from_method() {
        Pagination<Integer> original = new Pagination<>(
                List.of(1, 2, 3),
                3,
                0,
                1
        );

        Pagination<String> mapped = Pagination.from(
                original,
                Object::toString
        );

        assertEquals(List.of("1", "2", "3"), mapped.getItems());
        assertEquals(original.getTotalItems(), mapped.getTotalItems());
        assertEquals(original.getPage(), mapped.getPage());
        assertEquals(original.getTotalPages(), mapped.getTotalPages());
    }

    @Test
    void should_return_empty_items_when_original_items_are_empty() {
        Pagination<Integer> original = new Pagination<>(
                List.of(),
                0,
                0,
                0
        );

        Pagination<String> mapped = Pagination.from(
                original,
                Object::toString
        );

        assertTrue(mapped.getItems().isEmpty());
        assertEquals(0, mapped.getTotalItems());
        assertEquals(0, mapped.getPage());
        assertEquals(0, mapped.getTotalPages());
    }
}

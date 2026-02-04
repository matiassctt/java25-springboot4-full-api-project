package com.matiassctt.hexagonalapi.student.infrastructure.model.enums;

public enum StudentSortField {
    id("id"),
    name("name");

    private final String column;

    StudentSortField(String column) {
        this.column = column;
    }

    public String column() {
        return column;
    }
}

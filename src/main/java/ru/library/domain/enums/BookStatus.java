package ru.library.domain.enums;


import lombok.Getter;

public enum BookStatus {
    AVAILABLE("Доступна"),
    UNAVAILABLE("Недоступна");

    @Getter
    private final String value;


    BookStatus(String value) {
        this.value = value;
    }
}

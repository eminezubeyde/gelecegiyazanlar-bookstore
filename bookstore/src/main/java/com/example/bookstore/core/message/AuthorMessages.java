package com.example.bookstore.core.message;

public enum AuthorMessages {
    NOT_FOUND("Böyle bir yazar bulunamadı"),
    ALREADY_EXISTS("Böyle bir yazar zaten kayıtlı")
    ;


    private final String message;

    AuthorMessages(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return message;
    }

}

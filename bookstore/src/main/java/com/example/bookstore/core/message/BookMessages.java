package com.example.bookstore.core.message;

public enum BookMessages {
    NOT_FOUND("Böyle bir kitap bulunamadı"),
    SUCCESSFUL("Başarıyla eklendi");

    private final String message;

    BookMessages(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return message;
    }
}

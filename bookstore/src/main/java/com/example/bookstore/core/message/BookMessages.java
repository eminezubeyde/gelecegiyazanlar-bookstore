package com.example.bookstore.core.message;

public class BookMessages {
    public static final String NOT_FOUND = "Böyle bir kitap bulunamadı";

    private final String message;

    BookMessages(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return message;
    }
}

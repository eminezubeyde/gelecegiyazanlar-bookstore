package com.example.bookstore.core.message;

public enum CategoryMessages {
    NOT_FOUND("Böyle bir kategori bulunamadı"),
    ALREADY_EXISTS("Böyle bir kategori zaten kayıtlı"),
    SUCCESSFUL("Başarıyla eklendi"),
    NOT_SUCCESSFUL("Böyle bir kategori bulunamadı");


    private final String message;

    CategoryMessages(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return message;
    }
}

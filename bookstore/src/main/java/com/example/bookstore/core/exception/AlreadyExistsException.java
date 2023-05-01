package com.example.bookstore.core.exception;

public class AlreadyExistsException extends RuntimeException{
    public AlreadyExistsException(String message) {
        super(message);
    }
}

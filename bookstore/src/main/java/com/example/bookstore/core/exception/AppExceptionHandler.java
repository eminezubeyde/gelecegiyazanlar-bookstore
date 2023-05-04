package com.example.bookstore.core.exception;

import com.example.bookstore.core.result.ExceptionResult;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;

@RestControllerAdvice
public class AppExceptionHandler {
    @ExceptionHandler
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ExceptionResult generalExceptionHandler(GeneralException e,
                                                         HttpServletRequest request) {
        return new ExceptionResult(HttpStatus.BAD_REQUEST.toString(), e.getMessage(), request.getServletPath(), LocalDateTime.now());
    }
    @ExceptionHandler
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ExceptionResult entityNotFoundExceptionHandler(EntityNotFoundException e,
                                                          HttpServletRequest request) {
        return new ExceptionResult(HttpStatus.NOT_FOUND.toString(), e.getMessage(), request.getServletPath(), LocalDateTime.now());
    }


}

package com.example.bookstore.core.exception;

import com.example.bookstore.core.result.ExceptionResult;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class AppExceptionHandler {
    @ExceptionHandler(GeneralException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ExceptionResult generalExceptionHandler(GeneralException e,
                                                         HttpServletRequest request) {
        return new ExceptionResult(HttpStatus.BAD_REQUEST.toString(), e.getMessage(), request.getServletPath(), LocalDateTime.now());
    }
    @ExceptionHandler(EntityNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ExceptionResult entityNotFoundExceptionHandler(EntityNotFoundException e,
                                                          HttpServletRequest request) {
        return new ExceptionResult(HttpStatus.NOT_FOUND.toString(), e.getMessage(), request.getServletPath(), LocalDateTime.now());
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ExceptionResult entityNotFoundExceptionHandler(MethodArgumentNotValidException methodArgumentNotValidException,
                                                          HttpServletRequest request) {

        Map<String, String> validationErrors = new HashMap<String, String>();

        for (FieldError fieldError : methodArgumentNotValidException.getBindingResult().getFieldErrors()) {
            validationErrors.put(fieldError.getField(), fieldError.getDefaultMessage());
        }
        String message="";

        for (String value : validationErrors.values()){
            message+=value + "\n";
        }


        return new ExceptionResult(HttpStatus.NOT_FOUND.toString(),message, request.getServletPath(), LocalDateTime.now());
    }

}

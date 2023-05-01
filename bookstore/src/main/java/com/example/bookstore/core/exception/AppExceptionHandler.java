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
    public ExceptionResult alreadyExistsExceptionHandler(AlreadyExistsException e,
                                                         HttpServletRequest request){
      return getExceptionResponse(e,request,HttpStatus.NOT_FOUND.toString());
    }

    private ExceptionResult getExceptionResponse(RuntimeException e,
                                 HttpServletRequest request,
                                 String status){
        return new ExceptionResult(status,e.getMessage(), request.getServletPath(), LocalDateTime.now());
    }
}

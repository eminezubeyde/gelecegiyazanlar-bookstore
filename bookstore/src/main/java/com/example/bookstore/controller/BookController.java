package com.example.bookstore.controller;

import com.example.bookstore.business.BookService;
import com.example.bookstore.core.dto.requests.CreateBookRequest;
import com.example.bookstore.core.exception.EntityNotFoundException;
import com.example.bookstore.core.result.GeneralResult;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/book")
@RequiredArgsConstructor
public class BookController {
    private final BookService bookService;

    @PostMapping
    public GeneralResult create(@RequestBody CreateBookRequest request) throws EntityNotFoundException {
        return bookService.add(request);
    }

    @GetMapping
    public GeneralResult getAll() {
        return bookService.getAll();
    }

    @GetMapping("/{id}")
    public GeneralResult getById(@RequestParam long id) throws EntityNotFoundException {
        return bookService.getById(id);
    }
    @GetMapping("/getAllBooksByAuthorId")
    public GeneralResult getAllBooksByAuthorId(@RequestParam long id) throws EntityNotFoundException {
        return bookService.getAllBooksByAuthorId(id);
    }


    @DeleteMapping
    public void delete(@RequestParam long id) throws EntityNotFoundException {
        bookService.delete(id);
    }
}

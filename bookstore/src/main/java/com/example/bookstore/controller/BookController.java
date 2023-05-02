package com.example.bookstore.controller;

import com.example.bookstore.business.BookService;
import com.example.bookstore.core.dto.requests.CreateBookRequest;
import com.example.bookstore.core.result.GeneralResult;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/book")
@RequiredArgsConstructor
public class BookController {
    private final BookService bookService;

    @PostMapping
    public GeneralResult create(@RequestBody CreateBookRequest request) {
        return bookService.add(request);
    }

    @GetMapping
    public GeneralResult getAll() {
        return bookService.getAll();
    }

    @GetMapping("/{id}")
    public GeneralResult getById(@RequestParam long id) {
        return bookService.getById(id);
    }

    @DeleteMapping
    public void delete(@RequestParam long id) {
        bookService.delete(id);
    }
}

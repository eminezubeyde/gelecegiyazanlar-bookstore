package com.example.bookstore.controller;

import com.example.bookstore.business.BookService;
import com.example.bookstore.entity.Book;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/book")
@RequiredArgsConstructor
public class BookController {
    private final BookService bookService;

    @PostMapping
    public Book create(@RequestBody Book book) {
        return bookService.add(book);
    }

    @GetMapping
    public List<Book> getAll() {
        return bookService.getAll();
    }

    @GetMapping("/{id}")
    public Book getById(@RequestParam long id) {
        return bookService.getById(id);
    }

    @DeleteMapping
    public void delete(@RequestParam long id) {
        bookService.delete(id);
    }
}

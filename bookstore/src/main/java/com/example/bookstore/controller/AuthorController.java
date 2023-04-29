package com.example.bookstore.controller;

import com.example.bookstore.business.AuthorService;
import com.example.bookstore.entity.Author;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/author")
public class AuthorController {
    private final AuthorService authorService;

    @PostMapping
    public Author create(@RequestBody Author author) {
        return authorService.add(author);
    }

    @GetMapping
    public List<Author> getAll() {
        return authorService.getAll();
    }

    @GetMapping("/{id}")
    public Author getById(@RequestParam int id) {
        return authorService.getById(id);
    }

    @DeleteMapping
    public void delete(@RequestParam int id) {
        authorService.delete(id);
    }
}

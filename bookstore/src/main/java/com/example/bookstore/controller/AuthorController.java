package com.example.bookstore.controller;

import com.example.bookstore.business.AuthorService;
import com.example.bookstore.core.dto.requests.CreateAuthorRequest;
import com.example.bookstore.core.result.GeneralResult;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequiredArgsConstructor
@RequestMapping("api/author")
public class AuthorController {
    @Autowired
    private AuthorService authorService;

    @PostMapping
    public GeneralResult create(@RequestBody CreateAuthorRequest request) {
        return authorService.add(request);
    }

    @GetMapping
    public GeneralResult getAll() {
        return authorService.getAll();
    }

    @GetMapping("/{id}")
    public GeneralResult getById(@RequestParam long id) {
        return authorService.getById(id);
    }

    @DeleteMapping
    public void delete(@RequestParam long id) {
        authorService.delete(id);
    }
}

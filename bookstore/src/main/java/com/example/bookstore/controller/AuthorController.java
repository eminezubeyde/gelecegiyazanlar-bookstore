package com.example.bookstore.controller;

import com.example.bookstore.business.AuthorService;
import com.example.bookstore.core.dto.requests.CreateAuthorRequest;
import com.example.bookstore.core.exception.AlreadyExistsException;
import com.example.bookstore.core.exception.EntityNotFoundException;
import com.example.bookstore.core.result.GeneralResult;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;


@RestController
@RequiredArgsConstructor
@RequestMapping("api/author")
public class AuthorController {

    private final AuthorService authorService;

    @PostMapping
    public GeneralResult create( @Valid @RequestBody CreateAuthorRequest request) throws AlreadyExistsException {
        return authorService.add(request);
    }

    @GetMapping("/getall")
    public GeneralResult getAll() {
        return authorService.getAll();
    }

    @GetMapping
    public GeneralResult getById(@RequestParam long id) throws EntityNotFoundException {
        return authorService.getById(id);
    }
    @GetMapping("/{authorId}") // author/
    public GeneralResult getAllBooksByAuthorId(@PathVariable(name = "authorId") long id) throws EntityNotFoundException {
        return authorService.getAllBooksByAuthorId(id);
    }

    @DeleteMapping
    public void delete(@RequestParam long id) {
        authorService.delete(id);
    }
}

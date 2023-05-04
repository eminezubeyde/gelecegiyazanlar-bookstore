package com.example.bookstore.controller;

import com.example.bookstore.business.CategoryService;
import com.example.bookstore.core.dto.requests.CreateAuthorRequest;
import com.example.bookstore.core.dto.requests.CreateCategoryRequest;
import com.example.bookstore.core.result.GeneralResult;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/category")
@RequiredArgsConstructor
public class CategoryController {
    private final CategoryService categoryService;
    @PostMapping
    public GeneralResult create(@RequestBody CreateCategoryRequest request) {
        return categoryService.add(request);
    }

    @GetMapping
    public GeneralResult getAll() {
        return categoryService.getAll();
    }

    @GetMapping("/name")
    public GeneralResult getCategoryByName(@RequestParam String name) {
        return categoryService.getCategoryByName(name);
    }

    @DeleteMapping
    public void delete(@RequestParam long id) {
        categoryService.delete(id);
    }
}

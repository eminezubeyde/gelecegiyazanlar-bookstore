package com.example.bookstore.business;

import com.example.bookstore.core.dto.requests.CreateCategoryRequest;
import com.example.bookstore.core.result.GeneralResult;

public interface CategoryService {
    GeneralResult add(CreateCategoryRequest request);
    GeneralResult getAll();
    GeneralResult getCategoryByName(String name);
    void delete(long id);
}


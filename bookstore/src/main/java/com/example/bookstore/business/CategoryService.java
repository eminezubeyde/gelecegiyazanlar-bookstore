package com.example.bookstore.business;

import com.example.bookstore.core.dto.requests.CreateCategoryRequest;
import com.example.bookstore.core.exception.AlreadyExistsException;
import com.example.bookstore.core.exception.EntityNotFoundException;
import com.example.bookstore.core.result.GeneralResult;

public interface CategoryService {
    GeneralResult add(CreateCategoryRequest request) throws AlreadyExistsException;
    GeneralResult getAll();
    GeneralResult getCategoryByName(String name);
    void delete(long id) throws EntityNotFoundException;
}


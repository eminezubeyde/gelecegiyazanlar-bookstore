package com.example.bookstore.business;

import com.example.bookstore.core.dto.requests.CreateBookRequest;
import com.example.bookstore.core.exception.EntityNotFoundException;
import com.example.bookstore.core.result.GeneralResult;
import com.example.bookstore.entity.Book;

import java.util.List;

public interface BookService {
    GeneralResult add(CreateBookRequest request) throws EntityNotFoundException;

    GeneralResult getAll();

    GeneralResult getById(long id) throws EntityNotFoundException;

    void delete(long id) throws EntityNotFoundException;

    GeneralResult getAllBooksByCategoryId(long id) throws EntityNotFoundException;

}

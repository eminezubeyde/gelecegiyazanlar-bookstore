package com.example.bookstore.business;

import com.example.bookstore.core.dto.requests.CreateBookRequest;
import com.example.bookstore.core.result.GeneralResult;
import com.example.bookstore.entity.Book;

import java.util.List;

public interface BookService {
    GeneralResult add(CreateBookRequest request);

    GeneralResult getAll();

    GeneralResult getById(long id);

    void delete(long id);
}

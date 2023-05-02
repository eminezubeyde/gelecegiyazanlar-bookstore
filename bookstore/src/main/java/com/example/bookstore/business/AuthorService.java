package com.example.bookstore.business;

import com.example.bookstore.core.dto.requests.CreateAuthorRequest;
import com.example.bookstore.core.dto.responses.AuthorDTO;
import com.example.bookstore.core.result.GeneralResult;
import com.example.bookstore.entity.Author;

import java.util.List;

public interface AuthorService {
    GeneralResult add(CreateAuthorRequest request);

    GeneralResult getAll();

    GeneralResult getById(long id);

    void delete(long id);
}

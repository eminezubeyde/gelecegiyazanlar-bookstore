package com.example.bookstore.business;

import com.example.bookstore.entity.Author;

import java.util.List;

public interface AuthorService {
    Author add(Author author);

    List<Author> getAll();

    Author getById(long id);

    void delete(long id);
}

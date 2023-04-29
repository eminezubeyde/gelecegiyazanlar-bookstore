package com.example.bookstore.business;

import com.example.bookstore.entity.Author;

import java.util.List;

public interface AuthorService {
    Author add(Author author);

    List<Author> getAll();

    Author getById(int id);

    void delete(int id);
}

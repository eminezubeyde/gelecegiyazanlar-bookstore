package com.example.bookstore.business;

import com.example.bookstore.entity.Book;

import java.util.List;

public interface BookService {
    Book add(Book book);

    List<Book> getAll();

    Book getById(long id);

    void delete(long id);
}

package com.example.bookstore.business.Impl;

import com.example.bookstore.business.BookService;
import com.example.bookstore.entity.Book;
import com.example.bookstore.repository.BookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BookServiceImpl implements BookService {
    private final BookRepository repository;

    @Override
    public Book add(Book book) {
       
        return repository.save(book);
    }

    @Override
    public List<Book> getAll() {
        return repository.findAll();
    }

    @Override
    public Book getById(long id) {
        checkIfBookExists(id);
        Book book=repository.findById(id).orElseThrow();
        return book;
    }
    @Override
    public void delete(long id) {
        repository.deleteById(id);

    }
    private void checkIfBookExists(long id) {
        if(!repository.existsById(id)){
            throw new RuntimeException("böyle bir kitap bulunamadı");
        }
    }
}

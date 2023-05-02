package com.example.bookstore.business.Impl;

import com.example.bookstore.business.BookService;
import com.example.bookstore.core.dto.requests.CreateBookRequest;
import com.example.bookstore.core.dto.responses.BookDTO;
import com.example.bookstore.core.exception.EntityNotFoundException;
import com.example.bookstore.core.mapper.BookMapper;
import com.example.bookstore.core.message.BookMessages;
import com.example.bookstore.core.result.DataResult;
import com.example.bookstore.core.result.GeneralResult;
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
    public GeneralResult add(CreateBookRequest request) {
        Book book = BookMapper.INSTANCE.createBookRequestToBook(request);
        repository.save(book);
        BookDTO dto = BookMapper.INSTANCE.bookToBookDTO(book);


        return new DataResult<>(dto, BookMessages.SUCCESSFUL.toString());
    }

    @Override
    public GeneralResult getAll() {
        List<Book> books = repository.findAll();
        List<BookDTO> dtoList = books.stream().map(BookMapper.INSTANCE::bookToBookDTO).toList();
        return new DataResult<>(dtoList);
    }

    @Override
    public GeneralResult getById(long id) {
        checkIfBookExists(id);
        Book book = repository.findById(id).orElseThrow();
        return new DataResult<>(repository.findById(id), BookMessages.SUCCESSFUL.toString());
    }

    @Override
    public void delete(long id) {
        repository.deleteById(id);

    }

    private void checkIfBookExists(long id) {
        if (!repository.existsById(id)) {
            throw new EntityNotFoundException(BookMessages.NOT_FOUND.toString());
        }
    }
}

package com.example.bookstore.business.Impl;

import com.example.bookstore.business.AuthorService;
import com.example.bookstore.business.BookService;
import com.example.bookstore.business.CategoryService;
import com.example.bookstore.core.dto.requests.CreateBookRequest;
import com.example.bookstore.core.dto.responses.BookDTO;
import com.example.bookstore.core.exception.EntityNotFoundException;
import com.example.bookstore.core.mapper.BookMapper;
import com.example.bookstore.core.message.AuthorMessages;
import com.example.bookstore.core.message.BookMessages;
import com.example.bookstore.core.message.CategoryMessages;
import com.example.bookstore.core.result.DataResult;
import com.example.bookstore.core.result.GeneralResult;
import com.example.bookstore.entity.Author;
import com.example.bookstore.entity.Book;
import com.example.bookstore.entity.Category;
import com.example.bookstore.repository.AuthorRepository;
import com.example.bookstore.repository.BookRepository;
import com.example.bookstore.repository.CategoryRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class BookServiceImpl implements BookService {
    private final BookRepository repository;
    private final AuthorRepository authorRepository;
    private final CategoryRepository categoryRepository;

    @Override
    public GeneralResult add(CreateBookRequest request) throws EntityNotFoundException {
        log.info("book added method started with request : "+request);
        Optional<Author> optionalAuthor=authorRepository.findById(request.getAuthorId());
        if(optionalAuthor.isEmpty()){
            log.error(AuthorMessages.NOT_FOUND.toString());
            throw new EntityNotFoundException(AuthorMessages.NOT_FOUND.toString());
        }
        Optional<Category> optionalCategory = categoryRepository.findById(request.getCategoryId());
        if(optionalCategory.isEmpty()){
            log.error(CategoryMessages.NOT_FOUND.toString());
            throw new EntityNotFoundException(CategoryMessages.NOT_FOUND.toString());
        }

        Book book = BookMapper.INSTANCE.createBookRequestToBook(request);
        book.setAuthor(optionalAuthor.get());
        book.setCategory(optionalCategory.get());
        book.setCreatedDate(LocalDateTime.now());
        repository.save(book);
        BookDTO dto = BookMapper.INSTANCE.bookToBookDTO(book);

        log.info("book added method finish with response : "+dto);
        return new DataResult<>(dto, BookMessages.SUCCESSFUL.toString());
    }

    @Override
    public GeneralResult getAll() {
        List<Book> books = repository.findAll();
        List<BookDTO> dtoList = books.stream().map(BookMapper.INSTANCE::bookToBookDTO).toList();
        return new DataResult<>(dtoList);
    }

    @Override
    public GeneralResult getById(long id) throws EntityNotFoundException {
        checkIfBookExists(id);
        Book book = repository.findById(id).orElseThrow();
        BookDTO dto=BookMapper.INSTANCE.bookToBookDTO(book);
        return new DataResult<>(dto);
    }

    @Override
    public void delete(long id) throws EntityNotFoundException {
        checkIfBookExists(id);
        repository.deleteById(id);
    }

    private void checkIfBookExists(long id) throws EntityNotFoundException {
        if (!repository.existsById(id)) {
            throw new EntityNotFoundException(BookMessages.NOT_FOUND.toString());
        }
    }
}

package com.example.bookstore.core.mapper;

import com.example.bookstore.core.dto.responses.BookDTO;
import com.example.bookstore.entity.Book;

public interface BookMapper {
    BookDTO bookToBookDTO(Book book);

    Book bookDTOToBook(BookDTO bookDTO);
}

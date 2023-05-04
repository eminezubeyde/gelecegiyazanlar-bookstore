package com.example.bookstore.core.mapper;

import com.example.bookstore.core.dto.requests.CreateBookRequest;
import com.example.bookstore.core.dto.responses.BookDTO;
import com.example.bookstore.entity.Book;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(injectionStrategy = InjectionStrategy.CONSTRUCTOR , uses = {AuthorMapper.class, CategoryMapper.class})
public interface BookMapper {

    BookMapper INSTANCE = Mappers.getMapper(BookMapper.class);

    BookDTO bookToBookDTO(Book book);

    Book bookDTOToBook(BookDTO bookDTO);

    Book createBookRequestToBook(CreateBookRequest request);
}

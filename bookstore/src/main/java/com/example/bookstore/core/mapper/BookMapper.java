package com.example.bookstore.core.mapper;

import com.example.bookstore.core.dto.responses.BookDTO;
import com.example.bookstore.entity.Book;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface BookMapper {


    BookMapper INSTANCE = Mappers.getMapper( BookMapper.class );

    BookDTO bookToBookDTO(Book book);

    Book bookDTOToBook(BookDTO bookDTO);
}

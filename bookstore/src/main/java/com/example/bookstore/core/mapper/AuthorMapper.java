package com.example.bookstore.core.mapper;

import com.example.bookstore.core.dto.responses.AuthorDTO;
import com.example.bookstore.entity.Author;
import org.mapstruct.Mapper;

@Mapper
public interface AuthorMapper {
    AuthorDTO authorToAuthorDTO(Author author);

    Author authorDTOToAuthor(AuthorDTO authorDTO);
}

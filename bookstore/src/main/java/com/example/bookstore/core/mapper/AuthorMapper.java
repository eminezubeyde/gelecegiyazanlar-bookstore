package com.example.bookstore.core.mapper;

import com.example.bookstore.core.dto.requests.CreateAuthorRequest;
import com.example.bookstore.core.dto.responses.AuthorDTO;
import com.example.bookstore.entity.Author;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface AuthorMapper {

    static AuthorMapper MAPPER = Mappers.getMapper(AuthorMapper.class);


    AuthorDTO authorToAuthorDTO(Author author);

    Author authorDTOToAuthor(AuthorDTO authorDTO);

    AuthorDTO authorCreateRequestToAuthorDTO(CreateAuthorRequest request);

    Author createAuthorRequestToAuthor(CreateAuthorRequest request);
}

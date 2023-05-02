package com.example.bookstore.business.Impl;

import com.example.bookstore.business.AuthorService;
import com.example.bookstore.core.dto.requests.CreateAuthorRequest;
import com.example.bookstore.core.dto.responses.AuthorDTO;
import com.example.bookstore.core.exception.AlreadyExistsException;
import com.example.bookstore.core.exception.EntityNotFoundException;
import com.example.bookstore.core.mapper.AuthorMapper;
import com.example.bookstore.core.message.AuthorMessages;
import com.example.bookstore.core.result.DataResult;
import com.example.bookstore.core.result.GeneralResult;
import com.example.bookstore.entity.Author;
import com.example.bookstore.repository.AuthorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AuthorServiceImpl implements AuthorService {
    private final AuthorRepository authorRepository;

    @Override
    public GeneralResult add(CreateAuthorRequest request) {
        checkIfAuthorExistsByName(request.getName());
        Author author = AuthorMapper.MAPPER.createAuthorRequestToAuthor(request);
        authorRepository.save(author);
        AuthorDTO dto = AuthorMapper.MAPPER.authorToAuthorDTO(author);
        return new DataResult<>(dto, AuthorMessages.SUCCESSFUL.toString());

    }

    @Override
    public GeneralResult getAll() {
        List<Author> authors = authorRepository.findAll();
        List<AuthorDTO> responses = authors.stream().map(AuthorMapper.MAPPER::authorToAuthorDTO).toList();


        return new DataResult<>(responses,AuthorMessages.SUCCESSFUL.toString());
    }

    @Override
    public GeneralResult getById(long id) {
        checkIfAuthorExists(id);
        Author author = authorRepository.findById(id).orElseThrow();
        return new DataResult<>(author);
    }

    @Override
    public void delete(long id) {
        authorRepository.deleteById(id);
    }

    private void checkIfAuthorExistsByName(String name) throws AlreadyExistsException {
        if (authorRepository.existsByNameIgnoreCase(name)) {
            throw new AlreadyExistsException(AuthorMessages.ALREADY_EXISTS.toString());
        }
    }

    private void checkIfAuthorExists(long id) {
        if (!authorRepository.existsById(id)) {
            throw new EntityNotFoundException(AuthorMessages.NOT_FOUND.toString());
        }
    }
}

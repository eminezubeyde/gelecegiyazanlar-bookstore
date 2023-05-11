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
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class AuthorServiceImpl implements AuthorService {
    private final AuthorRepository authorRepository;

    private final AuthorMapper authorMapper;
    @Override
    public GeneralResult add(CreateAuthorRequest request) throws AlreadyExistsException {
        log.info("author add method started with request : "+request);
        checkIfAuthorExistsByName(request.getName());
        Author author = authorMapper.createAuthorRequestToAuthor(request);
        authorRepository.save(author);
        AuthorDTO dto = authorMapper.authorToAuthorDTO(author);
        log.info("author add method finished : " +dto);
        return new DataResult<>(dto, AuthorMessages.SUCCESSFUL.toString());

    }

    @Override
    public GeneralResult getAll() {
        List<Author> authors = authorRepository.findAll();
        List<AuthorDTO> responses = authors.stream().map(AuthorMapper.MAPPER::authorToAuthorDTO).toList();
        log.info("author list successfully retrieved");
        return new DataResult<>(responses);
    }

    @Override
    public GeneralResult getById(long id) throws EntityNotFoundException {
        checkIfAuthorExists(id);
        Author author = authorRepository.findById(id).orElseThrow();
        log.info("id ye göre yazar getirildi");
        return new DataResult<>(author);
    }


    @Override
    public void delete(long id) {
        authorRepository.deleteById(id);
        log.info("delete method succesfull");
    }

    private void checkIfAuthorExistsByName(String name) throws AlreadyExistsException {
        if (authorRepository.existsByNameIgnoreCase(name)) {
            log.error(AuthorMessages.ALREADY_EXISTS.toString());
            throw new AlreadyExistsException(AuthorMessages.ALREADY_EXISTS.toString());
        }
    }

    private void checkIfAuthorExists(long id) throws EntityNotFoundException {
        if (!authorRepository.existsById(id)) {
            log.error(AuthorMessages.NOT_FOUND.toString());
            throw new EntityNotFoundException(AuthorMessages.NOT_FOUND.toString());
        }
    }
}

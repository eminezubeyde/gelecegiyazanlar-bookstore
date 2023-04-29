package com.example.bookstore.business.Impl;

import com.example.bookstore.business.AuthorService;
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
    public Author add(Author author) {
        checkIfAuthorExistsByName(author.getName());
        return authorRepository.save(author);
    }

    @Override
    public List<Author> getAll() {

        return authorRepository.findAll();
    }

    @Override
    public Author getById(long id) {
        checkIfAuthorExists(id);
        Author author = authorRepository.findById(id).orElseThrow();
        return author;
    }


    @Override
    public void delete(long id) {
     authorRepository.deleteById(id);
    }

    private void checkIfAuthorExistsByName(String name) {
        if (authorRepository.existsByNameIgnoreCase(name)) {
            throw new RuntimeException("bu isimde bir yazar zaten kayıtlı");
        }
    }

    private void checkIfAuthorExists(long id) {
        if (!authorRepository.existsById(id)) {
            throw new RuntimeException("böyle bir yazar bulunamadı");
        }
    }

}

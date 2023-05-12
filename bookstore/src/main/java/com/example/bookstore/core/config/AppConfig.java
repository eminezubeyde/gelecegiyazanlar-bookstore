package com.example.bookstore.core.config;

import com.example.bookstore.repository.AuthorRepository;
import com.example.bookstore.repository.BookRepository;
import com.example.bookstore.repository.CategoryRepository;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class AppConfig {

    private final BookRepository bookRepository;
    private final AuthorRepository authorRepository;
    private final CategoryRepository categoryRepository;


    @PostConstruct
    public void setup(){
        /*Author author1=new Author();
        author1.setName("zübeyde");
        author1.setLastName("yalçın");

        Author author2=new Author();
        author2.setName("ayşe");
        author2.setLastName("yalçın");

        Book book1=new Book();
        book1.setTitle("küçük prens");
        book1.setCreatedDate(LocalDateTime.now());
        book1.setContent("küçük prens content");
        book1.setPublishedYear("2010");


        Book book2=new Book();
        book2.setTitle("heidi");
        book2.setCreatedDate(LocalDateTime.now());
        book2.setContent("heidi content");
        book2.setPublishedYear("2010");

        Book book3=new Book();
        book3.setTitle("olasılıksız");
        book3.setCreatedDate(LocalDateTime.now());
        book3.setContent("olasılıksız content");
        book3.setPublishedYear("2020");

        Category roman=new Category();
        roman.setName("ROMAN");
        categoryRepository.saveAndFlush(roman);

        Category polisiye=new Category();
        polisiye.setName("POLISIYE");
        polisiye.setParent(roman);
        categoryRepository.saveAndFlush(polisiye);

        Category gerilim=new Category();
        gerilim.setName("GERILIM");
        gerilim.setParent(roman);

        categoryRepository.saveAndFlush(gerilim);

        book2.setCategory(gerilim);
        book3.setCategory(polisiye);

        book1.setAuthor(author1);
        book3.setAuthor(author1);
        author1.addBook(book1);
        author1.addBook(book3);

        book2.setAuthor(author2);
        author2.addBook(book2);




        bookRepository.save(book1);
        bookRepository.save(book2);
        bookRepository.save(book3);

        authorRepository.save(author1);
        authorRepository.save(author2);
        ,
         */
    }

}

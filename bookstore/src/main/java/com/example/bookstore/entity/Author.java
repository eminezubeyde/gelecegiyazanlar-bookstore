package com.example.bookstore.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Author extends BaseModel {
    private String name;
    private String lastName;
    private String userName;
    private String password;
    private String telephone;
    private String birthDay;
    @OneToMany(mappedBy = "author")
    private List<Book> books;

    public void addBook(Book book){
        if(books==null){
            books=new ArrayList<>();
        }
        books.add(book);
    }
}

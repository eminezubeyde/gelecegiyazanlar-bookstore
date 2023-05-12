package com.example.bookstore.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Category extends BaseModel {

    private String name;

    @OneToOne(cascade = CascadeType.ALL)
    private Category parent;

    @OneToMany(mappedBy = "category")
    private List<Book> books;

    public void addBook(Book book){
        if(books==null){
           books= new ArrayList<>();
        }
        books.add(book);
    }


}

package com.example.bookstore.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String title;
    private String publicationYear;//yayın yılı
    private BookType bookType;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="author_id")
    private Author author;

}

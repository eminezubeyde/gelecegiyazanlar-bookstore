package com.example.bookstore.core.dto.requests;

import com.example.bookstore.entity.Author;
import com.example.bookstore.entity.BookType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CreateBookRequest {
    private String title;
    private String publicationYear;
    private BookType bookType;
    private Author author;
}

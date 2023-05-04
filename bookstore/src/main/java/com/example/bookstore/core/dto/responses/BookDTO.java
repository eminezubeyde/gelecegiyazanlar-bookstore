package com.example.bookstore.core.dto.responses;

import com.example.bookstore.entity.Author;
import com.example.bookstore.entity.Category;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class BookDTO {
    private String title;
    private String publicationYear;
    private String contents;
    private LocalDateTime createdDate;
    private long authorId;
    private Author author;
    private long categoryId;
    private Category category;
}

package com.example.bookstore.core.dto.requests;

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
public class CreateBookRequest {
    private String title;
    private String publicationYear;
    private String content;
    private LocalDateTime createdDate;
    private long authorId;
    private long categoryId;
}

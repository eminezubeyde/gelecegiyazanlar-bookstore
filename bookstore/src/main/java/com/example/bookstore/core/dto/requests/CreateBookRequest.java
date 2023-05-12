package com.example.bookstore.core.dto.requests;

import com.example.bookstore.entity.Author;
import com.example.bookstore.entity.Category;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CreateBookRequest {
    @NotBlank
    @Length(min = 2, message = "length must be greater than 2")
    private String title;
    private LocalDateTime publicationYear;
    private String content;
    private LocalDateTime createdDate;
    private long authorId;
    private long categoryId;
}

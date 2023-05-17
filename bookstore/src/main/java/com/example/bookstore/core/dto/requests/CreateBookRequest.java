package com.example.bookstore.core.dto.requests;

import com.example.bookstore.entity.Author;
import com.example.bookstore.entity.Category;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CreateBookRequest {
    @NotBlank
    @Length(min = 2, message = "length must be greater than 2")
    private String title;
    @NotBlank
    private LocalDateTime publicationYear;
    @NotBlank
    private String content;
    @NotNull(message = "date of birth cannot be empty")
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    private LocalDateTime createdDate;
    private long authorId;
    private long categoryId;
}

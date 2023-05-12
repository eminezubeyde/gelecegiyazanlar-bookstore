package com.example.bookstore.core.dto.requests;

import com.example.bookstore.entity.Category;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

@Getter
@Setter
public class CreateCategoryRequest {
    @NotBlank
    @Length(min = 2, message = "length must be greater than 2")
    private String name;
    private Long parentCategoryId;
}

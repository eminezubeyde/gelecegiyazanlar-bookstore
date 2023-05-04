package com.example.bookstore.core.dto.requests;

import com.example.bookstore.entity.Category;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateCategoryRequest {
    private String name;
    private Long parentCategoryId;
}

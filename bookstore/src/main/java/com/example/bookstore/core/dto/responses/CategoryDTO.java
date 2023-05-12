package com.example.bookstore.core.dto.responses;

import com.example.bookstore.entity.Category;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class CategoryDTO {
    private Long id;
    private String name;
    private CategoryDTO parent;

}

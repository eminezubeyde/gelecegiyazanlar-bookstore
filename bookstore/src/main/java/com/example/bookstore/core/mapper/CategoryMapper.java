package com.example.bookstore.core.mapper;

import com.example.bookstore.core.dto.requests.CreateCategoryRequest;
import com.example.bookstore.core.dto.responses.CategoryDTO;
import com.example.bookstore.entity.Category;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface CategoryMapper {
    static CategoryMapper INSTANCE = Mappers.getMapper(CategoryMapper.class);
    CategoryDTO categoryToCategoryDTO(Category category);
    Category categoryDTOToCategory(CategoryDTO dto);
    Category createCategoryRequestToCategory(CreateCategoryRequest request);
}

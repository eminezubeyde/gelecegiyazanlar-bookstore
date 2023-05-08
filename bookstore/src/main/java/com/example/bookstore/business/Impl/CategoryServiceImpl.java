package com.example.bookstore.business.Impl;

import com.example.bookstore.business.CategoryService;
import com.example.bookstore.core.dto.requests.CreateCategoryRequest;
import com.example.bookstore.core.dto.responses.CategoryDTO;
import com.example.bookstore.core.exception.AlreadyExistsException;
import com.example.bookstore.core.exception.EntityNotFoundException;
import com.example.bookstore.core.mapper.CategoryMapper;
import com.example.bookstore.core.message.CategoryMessages;
import com.example.bookstore.core.result.DataResult;
import com.example.bookstore.core.result.ErrorResult;
import com.example.bookstore.core.result.GeneralResult;
import com.example.bookstore.entity.Category;
import com.example.bookstore.repository.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CategoryServiceImpl implements CategoryService {
    private final CategoryRepository repository;

    @Override
    public GeneralResult add(CreateCategoryRequest request) throws AlreadyExistsException {
        // 1. parent 'i olmayan bir category eklemek .
        // ELEKTRONIK
        //2. parent'ı olan bir category eklemek .
        // TELEFON -> ELEKTRONIK
        checkIfCategoryExistsByName(request.getName());
        Category category = new Category();
        category.setName(request.getName());
        if (request.getParentCategoryId() != null) {
            Optional<Category> parentCategory = repository.findById(request.getParentCategoryId());
            parentCategory.ifPresent(category::setParent);
        }

        repository.save(category);
        return new DataResult<>(category,CategoryMessages.SUCCESSFUL.toString());
    }

    @Override
    public GeneralResult getAll() {
        List<Category> categories = repository.findAll();
        List<CategoryDTO> dtoList = categories.stream().map(CategoryMapper.INSTANCE::categoryToCategoryDTO).toList();
        return new DataResult<>(dtoList);
    }

    @Override
    public GeneralResult getCategoryByName(String name) {
        if(repository.getCategoryByName(name)==null){
            return new ErrorResult(CategoryMessages.NOT_FOUND.toString());
        }
        Category category = repository.getCategoryByName(name);
        CategoryDTO dto = CategoryMapper.INSTANCE.categoryToCategoryDTO(category);
        return new DataResult<>(dto);
    }

    @Override
    public void delete(long id) throws EntityNotFoundException {
        checkIfCategoryExists(id);
        repository.deleteById(id);

    }

    private void checkIfCategoryExists(Long id) throws EntityNotFoundException {
        if (!repository.existsById(id)) {
            throw new EntityNotFoundException(CategoryMessages.NOT_FOUND.toString());
        }
    }

    private void checkIfCategoryExistsByName(String name) throws AlreadyExistsException {
        if (repository.existsByNameIgnoreCase(name)) {
            throw new AlreadyExistsException(CategoryMessages.ALREADY_EXISTS.toString());
        }
    }
}

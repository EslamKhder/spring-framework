package com.spring.boot.restaurant.service.impl;
import com.spring.boot.restaurant.dto.CategoryDto;
import com.spring.boot.restaurant.exception.BadRequestException;
import com.spring.boot.restaurant.exception.NotFoundException;
import com.spring.boot.restaurant.mapper.CategoryMapper;
import com.spring.boot.restaurant.model.Category;
import com.spring.boot.restaurant.repository.CategoryRepo;
import com.spring.boot.restaurant.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryRepo categoryRepo;

    private final CategoryMapper categoryMapper;

    @Override
    public List<CategoryDto> getAllCategories() {
        List<Category> categories = categoryRepo.findAll();
        return categoryMapper.toDtoList(categories); // returns empty list if nothing found
    }

    @Override
    public CategoryDto getCategoryById(Long id) {
        return categoryRepo.findById(id)
                .map(categoryMapper::toDto)
                .orElse(null);
    }

    @Override
    public CategoryDto saveCategory(CategoryDto categoryDto) {
        if (categoryDto.getName() == null || categoryDto.getName().isBlank()) {
            throw new BadRequestException("Category name must not be empty");
        }
        Category category = categoryMapper.toEntity(categoryDto);
        return categoryMapper.toDto(categoryRepo.save(category));
    }

    @Override
    public boolean deleteCategory(Long id) {
        if (!categoryRepo.existsById(id)) {
            return false;
        }
        categoryRepo.deleteById(id);
        return true;
    }

    @Override
    public CategoryDto updateCategory(CategoryDto categoryDto) {
        if (categoryDto.getId() == null || !categoryRepo.existsById(categoryDto.getId())) {
            throw new NotFoundException("Category with ID " + categoryDto.getId() + " not found");
        }
        Category updated = categoryRepo.save(categoryMapper.toEntity(categoryDto));
        return categoryMapper.toDto(updated);
    }

    @Override
    public List<CategoryDto> getCategoriesByName(String name) {
        List<Category> categories = categoryRepo.findByName(name);
        return categoryMapper.toDtoList(categories);
    }

    @Override
    public List<CategoryDto> searchCategoriesByName(String name) {
        List<Category> categories = categoryRepo.findByNameContainingIgnoreCase(name);
        return categoryMapper.toDtoList(categories);
    }

    @Override
    public boolean deleteCategoriesByIds(List<Long> ids) {
        List<Category> categories = categoryRepo.findAllById(ids);
        if (categories.isEmpty()) {
            return false;
        }
        categoryRepo.deleteAll(categories);
        return true;
    }
}
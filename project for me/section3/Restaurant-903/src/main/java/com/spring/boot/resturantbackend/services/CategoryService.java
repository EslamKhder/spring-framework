package com.spring.boot.resturantbackend.services;

import com.spring.boot.resturantbackend.dto.CategoryDto;

import java.util.List;

public interface CategoryService {
    List<CategoryDto> getAllCategories();

    CategoryDto createCategory(CategoryDto categoryDto);

    List<CategoryDto> createListOfCategory(List<CategoryDto> categoryDto);

    CategoryDto updateCategory(CategoryDto categoryDto);

    List<CategoryDto> updateListOfCategory(List<CategoryDto> categoryDto);

    void deleteCategoryById(Long id);

    void deleteListOfCategory(List<Long> categoryIds);

    CategoryDto getCategoryById(Long id);
}

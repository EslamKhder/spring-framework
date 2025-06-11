package com.spring.boot.resturantbackend.services;

import com.spring.boot.resturantbackend.dto.CategoryDto;
import jakarta.transaction.SystemException;

import java.util.List;

public interface CategoryService {
    List<CategoryDto> getAllCategories() throws SystemException;

    CategoryDto createCategory(CategoryDto categoryDto) throws SystemException;

    List<CategoryDto> createListOfCategory(List<CategoryDto> categoryDto) throws SystemException;

    CategoryDto updateCategory(CategoryDto categoryDto) throws SystemException;

    List<CategoryDto> updateListOfCategory(List<CategoryDto> categoryDto) throws SystemException;

    void deleteCategoryById(Long id) throws SystemException;

    void deleteListOfCategory(List<Long> categoryIds) throws SystemException;

    CategoryDto getCategoryById(Long id) throws SystemException;
}

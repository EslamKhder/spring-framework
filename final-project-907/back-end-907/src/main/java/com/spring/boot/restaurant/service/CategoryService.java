package com.spring.boot.restaurant.service;

import com.spring.boot.restaurant.dto.CategoryDto;

import java.util.List;

public interface CategoryService {
    /**
     * Retrieve all categories.
     *
     * @return a list of all category DTOs
     */
    List<CategoryDto> getAllCategories();

    /**
     * Retrieve a category by its ID.
     *
     * @param id the ID of the category
     * @return the corresponding category DTO
     */
    CategoryDto getCategoryById(Long id);

    /**
     * Save a new category.
     *
     * @param categoryDto the category data to save
     * @return the saved category DTO
     */
    CategoryDto saveCategory(CategoryDto categoryDto);

    /**
     * Update an existing category.
     *
     * @param categoryDto the updated category data
     * @return the updated category DTO
     */
    CategoryDto updateCategory(CategoryDto categoryDto);

    /**
     * Delete a category by its ID.
     *
     * @param id the ID of the category to delete
     * @return true if deletion was successful, false otherwise
     */
    boolean deleteCategory(Long id);

    /**
     * Delete multiple categories by their IDs.
     *
     * @param ids a list of category IDs to delete
     * @return true if deletion was successful, false otherwise
     */
    boolean deleteCategoriesByIds(List<Long> ids);

    /**
     * Retrieve categories by exact name.
     *
     * @param name the exact name of the category
     * @return a list of matching category DTOs
     */
    List<CategoryDto> getCategoriesByName(String name);

    /**
     * Search categories by name (partial match).
     *
     * @param name the name or part of it to search
     * @return a list of matching category DTOs
     */
    List<CategoryDto> searchCategoriesByName(String name);
}

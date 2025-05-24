package com.spring.boot.restaurant.service;

import com.spring.boot.restaurant.dto.ProductDto;

import java.util.List;

public interface ProductService {
    /**
     * Retrieve all products.
     *
     * @return a list of all product DTOs
     */
    List<ProductDto> getAllProducts();

    /**
     * Retrieve a product by its ID.
     *
     * @param id the ID of the product
     * @return the product DTO
     */
    ProductDto getProductById(Long id);

    /**
     * Save a new product.
     *
     * @param productDto the product data to save
     * @return the saved product DTO
     */
    ProductDto saveProduct(ProductDto productDto);

    /**
     * Update an existing product.
     *
     * @param productDto the updated product data
     * @return the updated product DTO
     */
    ProductDto updateProduct(ProductDto productDto);

    /**
     * Delete a product by its ID.
     *
     * @param id the ID of the product to delete
     * @return true if deletion was successful, false otherwise
     */
    boolean deleteProductById(Long id);

    /**
     * Delete multiple products by their IDs.
     *
     * @param ids a list of product IDs to delete
     * @return true if deletion was successful, false otherwise
     */
    boolean deleteProductsByIds(List<Long> ids);

    /**
     * Retrieve products by category ID.
     *
     * @param categoryId the ID of the category
     * @return a list of product DTOs in the specified category
     */
    List<ProductDto> getProductsByCategoryId(Long categoryId);

    /**
     * Retrieve products by category name.
     *
     * @param categoryName the name of the category
     * @return a list of product DTOs in the specified category
     */
    List<ProductDto> getProductsByCategoryName(String categoryName);

    /**
     * Search for products by name or description (full or partial match).
     *
     * @param keyword the keyword to search for
     * @return a list of matching product DTOs
     */
    List<ProductDto> searchProducts(String keyword);
}
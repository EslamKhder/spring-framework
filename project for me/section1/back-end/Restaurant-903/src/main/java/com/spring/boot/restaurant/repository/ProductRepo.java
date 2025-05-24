package com.spring.boot.restaurant.repository;

import com.spring.boot.restaurant.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepo extends JpaRepository<Product, Long> {
    // Find products by exact category ID
    List<Product> findByCategoryId(Long categoryId);

    // Find products by exact category name (needs join on category)
    List<Product> findByCategoryName(String categoryName);

//    @Query("SELECT p FROM Product p WHERE LOWER(p.name) LIKE LOWER(CONCAT('%', :keyword, '%')) " +
//            "OR LOWER(p.description) LIKE LOWER(CONCAT('%', :keyword, '%'))")
    List<Product> findByNameContainingIgnoreCaseOrDescriptionContainingIgnoreCase(String keyword1, String keyword2);

}
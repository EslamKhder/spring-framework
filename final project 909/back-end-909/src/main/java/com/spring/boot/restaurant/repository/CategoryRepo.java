package com.spring.boot.restaurant.repository;

import com.spring.boot.restaurant.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CategoryRepo extends JpaRepository<Category, Long> {
    // Find categories by exact name
    List<Category> findByName(String name);

    // Search categories by name containing keyword (case insensitive)
    List<Category> findByNameContainingIgnoreCase(String name);
}

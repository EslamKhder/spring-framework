package com.spring.boot.resturantbackend.repositories;

import com.spring.boot.resturantbackend.models.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CategoryRepo extends JpaRepository<Category, Long> {
    List<Category> findAllByOrderByNameAsc();
}

package com.spring.boot.resturantbackend.repositories;

import com.spring.boot.resturantbackend.models.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepo extends JpaRepository<Product, Long> {
    Page<Product> findAllByOrderByIdAsc(Pageable pageable);

    @Query(value = "select p from Product p where p.category.id=:id order by p.id")
    Page<Product> findAllProductsByCategoryIdByOrderByIdAsc(Long id, Pageable pageable);

    @Query("SELECT p FROM Product p WHERE lower(p.name) LIKE lower(concat('%', :key, '%')) OR lower(p.description) LIKE lower(concat('%', :key, '%')) ORDER BY p.id")
    Page<Product> getAllProductsByKeyByOrderByIdAsc(@Param("key") String key, Pageable pageable);

    @Query(value = "SELECT p FROM Product p WHERE  p.category.id = :id and (lower(p.name) LIKE lower(concat('%', :key, '%')) OR lower(p.description) LIKE lower(concat('%', :key, '%'))) ORDER BY p.id")
    Page<Product> getAllProductsByKeyByCategoryIdByOrderByIdAsc(@Param("id") Long categoryId, @Param("key") String key, Pageable pageable);
}

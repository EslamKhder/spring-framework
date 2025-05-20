package com.spring.boot.restaurant.controller;

import com.spring.boot.restaurant.dto.CategoryDto;
import com.spring.boot.restaurant.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/categories")
@RequiredArgsConstructor
@CrossOrigin("http://localhost:4200")
public class CategoryController {

    private final CategoryService categoryService;

    @GetMapping("/getAll")
    public ResponseEntity<List<CategoryDto>> getAllCategories() {
        return ResponseEntity.ok(categoryService.getAllCategories());
    }

    @GetMapping("/getOne/{id}")
    public ResponseEntity<CategoryDto> getCategoryById(@PathVariable Long id) {
        return ResponseEntity.ok(categoryService.getCategoryById(id));
    }

    @PostMapping("/create")
    public ResponseEntity<CategoryDto> saveCategory(@RequestBody CategoryDto categoryDto) {
        return ResponseEntity.ok(categoryService.saveCategory(categoryDto));
    }

    @PutMapping("/update")
    public ResponseEntity<CategoryDto> updateCategory(@RequestBody CategoryDto categoryDto) {
        return ResponseEntity.ok(categoryService.updateCategory(categoryDto));
    }

    @DeleteMapping("/deleteOne/{id}")
    public ResponseEntity<Boolean> deleteCategory(@PathVariable Long id) {
        return ResponseEntity.ok(categoryService.deleteCategory(id));
    }

    @DeleteMapping("/deleteList")
    public ResponseEntity<Boolean> deleteCategoriesByIds(@RequestBody List<Long> ids) {
        return ResponseEntity.ok(categoryService.deleteCategoriesByIds(ids));
    }

    @GetMapping("/getByName")
    public ResponseEntity<List<CategoryDto>> getCategoriesByName(@RequestParam String name) {
        return ResponseEntity.ok(categoryService.getCategoriesByName(name));
    }

    @GetMapping("/search")
    public ResponseEntity<List<CategoryDto>> searchCategoriesByName(@RequestParam String name) {
        return ResponseEntity.ok(categoryService.searchCategoriesByName(name));
    }
}
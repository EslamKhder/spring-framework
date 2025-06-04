package com.spring.boot.resturantbackend.controllers;

import com.spring.boot.resturantbackend.dto.CategoryDto;
import com.spring.boot.resturantbackend.services.CategoryService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.transaction.SystemException;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@Tag(
        name = "CategoryController",
        description = "Category Controller to create , update , delete and select"
)
@RestController
@RequestMapping("/categories")
@CrossOrigin("http://localhost:4200")
public class CategoryController {
    @Autowired
    private CategoryService categoryService;

    @Operation(
            summary = "all-categories API",
            description = "this api to get all categories"
    )
    @GetMapping("/all-categories")
    public ResponseEntity<List<CategoryDto>> getAllCategories() {
        return ResponseEntity.ok(categoryService.getAllCategories());
    }

    @PostMapping("/create-category")
    public ResponseEntity<CategoryDto> createCategory(@RequestBody @Valid CategoryDto categoryDto) throws SystemException {
        return ResponseEntity.created(URI.create("create-category")).body(categoryService.createCategory(categoryDto));
    }

    @GetMapping("/get-category/{id}")
    public ResponseEntity<CategoryDto> getCategoryById(@PathVariable Long id) throws SystemException {
        return ResponseEntity.ok(categoryService.getCategoryById(id));
    }

    @GetMapping("/eslam/{id}")
    public ResponseEntity<CategoryDto> get(@PathVariable Long id) throws SystemException {
        return ResponseEntity.ok(categoryService.getCategoryById(id));
    }
}

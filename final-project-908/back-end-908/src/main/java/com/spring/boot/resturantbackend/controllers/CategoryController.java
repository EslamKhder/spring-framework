package com.spring.boot.resturantbackend.controllers;

import com.spring.boot.resturantbackend.IdException;
import com.spring.boot.resturantbackend.dto.CategoryDto;
import com.spring.boot.resturantbackend.dto.ExceptionDto;
import com.spring.boot.resturantbackend.services.CategoryService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
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

@RestController
@RequestMapping("/categories")
@Tag(
        name = "Category Controller",
        description = "api mange category"
)
public class CategoryController {
    @Autowired
    private CategoryService categoryService;


    @Operation(
            summary = "get all categories",
            description = "api to get all categories"
    )
    @ApiResponses({
            @ApiResponse(
                    responseCode = "200",
                    description = "Http status get all categories success",
                    content = @Content(
                            schema = @Schema(implementation = CategoryDto.class)
                    )
            ),
            @ApiResponse(
                    responseCode = "500",
                    description = "Http status no categories found",
                    content = @Content(
                            schema = @Schema(implementation = ExceptionDto.class)
                    )
            )
    })
    @GetMapping("/all-categories")
    public ResponseEntity<List<CategoryDto>> getAllCategories() throws SystemException {
        return ResponseEntity.ok(categoryService.getAllCategories());
    }










    @Operation(
            summary = "create category"
    )
    @ApiResponses({
            @ApiResponse(
                    responseCode = "200",
                    description = "Http Status create category"
            ),
            @ApiResponse(
                    responseCode = "500",
                    description = "Http Status internal server error",
                    content = @Content(
                            schema = @Schema(implementation = ExceptionDto.class)
                    )
            ),
    })
    @PostMapping("/create-category")
    public ResponseEntity<CategoryDto> createCategory(@RequestBody @Valid CategoryDto categoryDto) throws SystemException {
        return ResponseEntity.created(URI.create("create-category")).body(categoryService.createCategory(categoryDto));
    }







    @Operation(
            summary = "get category by id"
    )
    @ApiResponses({
            @ApiResponse(
                    responseCode = "200",
                    description = "Http Status get category by id"
            ),
            @ApiResponse(
                    responseCode = "500",
                    description = "Http Status internal server error",
                    content = @Content(
                            schema = @Schema(implementation = ExceptionDto.class)
                    )
            ),
            @ApiResponse(
                    responseCode = "404",
                    description = "Http Status Not Found",
                    content = @Content(
                            schema = @Schema(implementation = ExceptionDto.class)
                    )
            ),
    })
    @GetMapping("/get-category/{id}")
    public ResponseEntity<CategoryDto> getCategoryById(@PathVariable Long id) throws SystemException {
        return ResponseEntity.ok(categoryService.getCategoryById(id));
    }
}

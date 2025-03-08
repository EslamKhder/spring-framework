package com.spring.restaurant.controller;

import com.spring.restaurant.service.CategoryService;
import com.spring.restaurant.service.dto.CategoryDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/category")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;


    @GetMapping
    ResponseEntity<List<CategoryDto>> categories(){
        return  ResponseEntity.ok(categoryService.getAllCategory());
    }
}

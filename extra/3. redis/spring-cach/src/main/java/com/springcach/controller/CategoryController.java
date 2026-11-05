package com.springcach.controller;

import com.springcach.model.Category;
import com.springcach.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/category")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;


    @GetMapping("/all")
    ResponseEntity<List<Category>> categories(){
        return  ResponseEntity.ok(categoryService.getAllCategory());
    }

    @PostMapping("/save")
    ResponseEntity<Void> saveCategories(@RequestBody Category category){
        categoryService.addCategory(category);
        return  ResponseEntity.ok().build();
    }


    @PutMapping("/update")
    ResponseEntity<Category> update(@RequestBody Category category){
        return  ResponseEntity.ok(categoryService.update(category));
    }

    @DeleteMapping("/delete")
    ResponseEntity<Void> saveCategories(@RequestParam Long id){
        categoryService.removeCategory(id);
        return  ResponseEntity.ok().build();
    }

    @GetMapping("/get")
    ResponseEntity<Category> getById(@RequestParam Long id){
        return  ResponseEntity.ok(categoryService.getById(id));
    }
}

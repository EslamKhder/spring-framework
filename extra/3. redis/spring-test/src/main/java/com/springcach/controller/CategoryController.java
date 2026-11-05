package com.springcach.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/category")
public class CategoryController {

    @GetMapping("/all")
    ResponseEntity<List<String>> categories(){
        return  ResponseEntity.ok(
                List.of("ahmed", "osama", "ali")
        );
    }

}

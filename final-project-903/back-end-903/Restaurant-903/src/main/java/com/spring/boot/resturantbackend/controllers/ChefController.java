package com.spring.boot.resturantbackend.controllers;

import com.spring.boot.resturantbackend.dto.ChefDto;
import com.spring.boot.resturantbackend.services.ChefService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/chefs")
@CrossOrigin("http://localhost:4200")
public class ChefController {
    @Autowired
    private ChefService chefService;

    @GetMapping("/all-chefs")
    public ResponseEntity<List<ChefDto>> getAllChefs() {
        return ResponseEntity.ok(chefService.getAllChefs());
    }
}

package com.spring.boot.restaurant.controller;

import com.spring.boot.restaurant.dto.ChefDto;
import com.spring.boot.restaurant.service.ChefService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/chefs")
public class ChefController {

    private final ChefService chefService;

    @Autowired
    public ChefController(ChefService chefService) {
        this.chefService = chefService;
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<ChefDto>> getAllChefs() {
        return ResponseEntity.ok(chefService.getAllChefs());
    }

    @GetMapping("/getOne/{id}")
    public ResponseEntity<ChefDto> getChefById(@PathVariable Long id) {
        ChefDto chef = chefService.getChefById(id);
        if (chef != null) {
            return ResponseEntity.ok(chef);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/createOne")
    public ResponseEntity<ChefDto> createChef(@RequestBody ChefDto chefDto) {
        ChefDto savedChef = chefService.saveChef(chefDto);
        return ResponseEntity.ok(savedChef);
    }

    @PutMapping("/update")
    public ResponseEntity<ChefDto> updateChef(@RequestBody ChefDto chefDto) {
        ChefDto updatedChef = chefService.updateChef(chefDto);
        return ResponseEntity.ok(updatedChef);
    }

    @DeleteMapping("/deleteOne/{id}")
    public ResponseEntity<Void> deleteChef(@PathVariable Long id) {
        boolean deleted = chefService.deleteChef(id);
        return deleted ? ResponseEntity.noContent().build() : ResponseEntity.notFound().build();
    }
}
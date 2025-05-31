package com.spring.boot.restaurant.service;

import com.spring.boot.restaurant.dto.ChefDto;

import java.util.List;

public interface ChefService {
    List<ChefDto> getAllChefs();
    ChefDto getChefById(Long id);
    ChefDto saveChef(ChefDto chefDto);
    ChefDto updateChef(ChefDto chefDto);
    boolean deleteChef(Long id);
}

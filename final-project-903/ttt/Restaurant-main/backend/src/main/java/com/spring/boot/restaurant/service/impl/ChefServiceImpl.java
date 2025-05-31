package com.spring.boot.restaurant.service.impl;

import com.spring.boot.restaurant.dto.ChefDto;
import com.spring.boot.restaurant.mapper.ChefMapper;
import com.spring.boot.restaurant.model.Chef;
import com.spring.boot.restaurant.model.Product;
import com.spring.boot.restaurant.repository.ChefRepo;
import com.spring.boot.restaurant.service.ChefService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ChefServiceImpl implements ChefService {

    private final ChefRepo chefRepository;
    private final ChefMapper chefMapper;

    public ChefServiceImpl(ChefRepo chefRepository, ChefMapper chefMapper) {
        this.chefRepository = chefRepository;
        this.chefMapper = chefMapper;
    }
    @Override
    public List<ChefDto> getAllChefs() {
        List<Chef> chefs = chefRepository.findAll();
        return chefMapper.toDtoList(chefs);
    }

    @Override
    public ChefDto getChefById(Long id) {
        return chefRepository.findById(id)
                .map(chefMapper::toDto)
                .orElse(null);
    }

    @Override
    public ChefDto saveChef(ChefDto chefDto) {
        Chef savedChef = chefRepository.save(chefMapper.toEntity(chefDto));
        return chefMapper.toDto(savedChef);
    }

    @Override
    public ChefDto updateChef(ChefDto chefDto) {
        Chef updatedChef = chefRepository.save(chefMapper.toEntity(chefDto));
        return chefMapper.toDto(updatedChef);
    }

    @Override
    public boolean deleteChef(Long id) {
        if (chefRepository.existsById(id)) {
            chefRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
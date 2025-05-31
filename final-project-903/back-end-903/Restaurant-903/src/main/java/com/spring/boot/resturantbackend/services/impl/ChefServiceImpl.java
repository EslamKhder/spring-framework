package com.spring.boot.resturantbackend.services.impl;

import com.spring.boot.resturantbackend.dto.ChefDto;
import com.spring.boot.resturantbackend.mappers.ChefMapper;
import com.spring.boot.resturantbackend.models.Chef;
import com.spring.boot.resturantbackend.repositories.ChefRepo;
import com.spring.boot.resturantbackend.services.ChefService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ChefServiceImpl implements ChefService {
    @Autowired
    private ChefRepo chefRepo;

    @Override
    public List<ChefDto> getAllChefs() {
        List<Chef> chefsList = chefRepo.findAllByOrderByIdAsc();
        return chefsList.stream().map(ChefMapper.CHEF_MAPPER::toChefDto).toList();
    }
}

package com.spring.restaurant.service.Impl;

import com.spring.restaurant.mapper.CategoryMapper;
import com.spring.restaurant.repository.CategoryRepository;
import com.spring.restaurant.service.CategoryService;
import com.spring.restaurant.service.dto.CategoryDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CategoryServiceImpl implements CategoryService {
    @Autowired
    private CategoryRepository categoryRepository;


    @Override
    public List<CategoryDto> getAllCategory() {
        return CategoryMapper.CATEGORY_MAPPER.toDtoList(categoryRepository.findAll().stream()
                .collect(Collectors.toList()));
    }

}

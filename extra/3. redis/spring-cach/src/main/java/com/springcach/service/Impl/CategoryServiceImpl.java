package com.springcach.service.Impl;

import com.springcach.model.Category;
import com.springcach.repository.CategoryRepository;
import com.springcach.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.Caching;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class CategoryServiceImpl implements CategoryService {
    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    @Cacheable(value = "category", key = "'allCategories'")
    public List<Category> getAllCategory() {
        return categoryRepository.findAll();
    }

    @Override
    @CacheEvict(value = "category", key = "'allCategories'")
    // if add id = 99  api get by id get form cache for first one.........
    public Category addCategory(Category category) {
        return categoryRepository.save(category);
    }

    // @CacheEvict(value = "category", key = "'allCategories'")
    // remove id 1 ..........................  ping getById and getAll
    @Override
    public void removeCategory(Long id) {
        categoryRepository.deleteById(id);
    }

    // 1
    // category [customCategory1: {}]
    // 2
    // category [customCategory2: {}]
    // @Cacheable(value = "category", key = "customCategory")
    // 2
    // category [customCategory3: {}]
    // @Cacheable(value = "category", key = "customCategory")
    @Cacheable(value = "category", key = "'customCategory' + #id") // 99
    @Override
    public Category getById(Long id) {
        return categoryRepository.findById(id).get();
    }


    // update id  1 ************  ERROR   must ping getById and getAll
    @Override
    public Category update(Category category) {
        return categoryRepository.save(category);
    }
}

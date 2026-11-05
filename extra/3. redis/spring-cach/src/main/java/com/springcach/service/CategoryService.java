package com.springcach.service;


import com.springcach.model.Category;

import java.util.List;

public interface CategoryService {
    List<Category> getAllCategory();
    Category addCategory(Category category);
    Category update(Category category);
    void removeCategory(Long id);
    Category getById(Long id);
}

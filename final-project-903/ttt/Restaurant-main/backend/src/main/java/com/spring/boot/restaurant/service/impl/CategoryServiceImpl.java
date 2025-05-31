package com.spring.boot.restaurant.service.impl;
import com.spring.boot.restaurant.dto.BundleMessage;
import com.spring.boot.restaurant.dto.CategoryDto;
import com.spring.boot.restaurant.exception.BadRequestException;
import com.spring.boot.restaurant.exception.ConflictException;
import com.spring.boot.restaurant.exception.NotFoundException;
import com.spring.boot.restaurant.mapper.CategoryMapper;
import com.spring.boot.restaurant.model.Category;
import com.spring.boot.restaurant.repository.CategoryRepo;
import com.spring.boot.restaurant.service.CategoryService;
import com.spring.boot.restaurant.service.bundleService.BundleTranslatorService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryRepo categoryRepo;

    private final CategoryMapper categoryMapper;

    @Autowired
    private BundleTranslatorService bundleTranslatorService;

    @Override
    public List<CategoryDto> getAllCategories() {
        List<Category> categories = categoryRepo.findAllByOrderByIdAsc();
        return categoryMapper.toDtoList(categories);
    }

    @Override
    public CategoryDto getCategoryById(Long id) {
        Category category = categoryRepo.findById(id)
                .orElseThrow(() -> {
                    BundleMessage message = bundleTranslatorService.getBundleMessage("category.id.not.found");
                    return new NotFoundException(message);
                });
        return categoryMapper.toDto(category);
    }

    @Override
    public CategoryDto saveCategory(CategoryDto categoryDto) {
        if (categoryDto.getName() == null || categoryDto.getName().isBlank()) {
            BundleMessage message = bundleTranslatorService.getBundleMessage("category.name.empty");
            throw new BadRequestException(message);
        }

        Category category = categoryMapper.toEntity(categoryDto);
        return categoryMapper.toDto(categoryRepo.save(category));
    }

    @Override
    public List<CategoryDto> saveCategoryList(List<CategoryDto> categoryDtoList) {
        if (categoryDtoList == null || categoryDtoList.isEmpty()) {
            BundleMessage message = bundleTranslatorService.getBundleMessage("category.list.empty");
            throw new BadRequestException(message);
        }

        for (CategoryDto dto : categoryDtoList) {
            if (dto.getName() == null || dto.getName().isBlank()) {
                BundleMessage message = bundleTranslatorService.getBundleMessage("category.name.empty");
                throw new BadRequestException(message);
            }
        }

        List<Category> categories = categoryMapper.toEntityList(categoryDtoList);
        List<Category> savedCategories = categoryRepo.saveAll(categories);
        return categoryMapper.toDtoList(savedCategories);
    }

    @Override
    public boolean deleteCategory(Long id) {
        if (!categoryRepo.existsById(id)) {
            BundleMessage message = bundleTranslatorService.getBundleMessage("category.id.not.found");
            throw new NotFoundException(message);
        }

        try {
            categoryRepo.deleteById(id);
            return true;
        } catch (Exception e) {
            BundleMessage message = bundleTranslatorService.getBundleMessage("category.delete.failed");
            throw new BadRequestException(message);
        }
    }

    @Override
    public boolean deleteCategoriesByIds(List<Long> ids) {
        if (ids == null || ids.isEmpty()) {
            BundleMessage message = bundleTranslatorService.getBundleMessage("category.list.empty");
            throw new BadRequestException(message);
        }

        List<Category> categories = categoryRepo.findAllById(ids);
        if (categories.isEmpty()) {
            BundleMessage message = bundleTranslatorService.getBundleMessage("category.list.delete.failed");
            throw new NotFoundException(message);
        }

        try {
            categoryRepo.deleteAll(categories);
            return true;
        } catch (Exception e) {
            BundleMessage message = bundleTranslatorService.getBundleMessage("category.list.delete.failed");
            throw new BadRequestException(message);
        }
    }

    @Override
    public CategoryDto updateCategory(CategoryDto categoryDto) {
        if (categoryDto.getId() == null || !categoryRepo.existsById(categoryDto.getId())) {
            BundleMessage message = bundleTranslatorService.getBundleMessage("category.id.not.found");
            throw new NotFoundException(message);
        }

        if (categoryDto.getName() == null || categoryDto.getName().isBlank()) {
            BundleMessage message = bundleTranslatorService.getBundleMessage("category.name.empty");
            throw new BadRequestException(message);
        }

        Optional<Category> existingByName = categoryRepo.findByName(categoryDto.getName()).stream()
                .filter(c -> !c.getId().equals(categoryDto.getId()))
                .findFirst();

        if (existingByName.isPresent()) {
            BundleMessage message = bundleTranslatorService.getBundleMessage("category.name.duplicate");
            throw new ConflictException(message);
        }

        Category updated = categoryRepo.save(categoryMapper.toEntity(categoryDto));
        return categoryMapper.toDto(updated);
    }

    @Override
    public List<CategoryDto> getCategoriesByName(String name) {
        if (name == null || name.isBlank()) {
            BundleMessage message = bundleTranslatorService.getBundleMessage("category.name.empty");
            throw new BadRequestException(message);
        }
        return categoryMapper.toDtoList(categoryRepo.findByName(name));
    }

    @Override
    public List<CategoryDto> searchCategoriesByName(String name) {
        if (name == null || name.isBlank()) {
            BundleMessage message = bundleTranslatorService.getBundleMessage("category.name.empty");
            throw new BadRequestException(message);
        }
        return categoryMapper.toDtoList(categoryRepo.findByNameContainingIgnoreCase(name));
    }

}
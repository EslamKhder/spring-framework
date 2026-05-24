package com.spring.boot.restaurant.mapper;

import com.spring.boot.restaurant.dto.CategoryDto;
import com.spring.boot.restaurant.model.Category;
import org.mapstruct.Mapper;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CategoryMapper {
    CategoryDto toDto(Category category);
    Category toEntity(CategoryDto dto);

    List<CategoryDto> toDtoList(List<Category> categories);
    List<Category> toEntityList(List<CategoryDto> dtos);
}
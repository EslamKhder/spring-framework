package com.spring.boot.resturantbackend.mappers;

import com.spring.boot.resturantbackend.dto.CategoryDto;
import com.spring.boot.resturantbackend.models.Category;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface CategoryMapper {
    CategoryMapper CATEGORY_MAPPER = Mappers.getMapper(CategoryMapper.class);

    CategoryDto toCategoryDto(Category category);

    Category toCategory(CategoryDto categoryDto);

}

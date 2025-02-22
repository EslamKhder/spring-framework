package com.spring.restaurant.mapper;


import com.spring.restaurant.model.Category;
import com.spring.restaurant.service.dto.CategoryDto;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface CategoryMapper {

    CategoryMapper CATEGORY_MAPPER = Mappers.getMapper(CategoryMapper.class);


    CategoryDto toDto(Category category);
    List<CategoryDto> toDtoList(List<Category> categoryList);

    Category toEntity(CategoryDto categoryDto);
    List<Category> toEntityList(List<CategoryDto> categoryDtoList);

}

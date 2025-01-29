package springdemo.finalprojectrestoran.Mapper;


import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
import springdemo.finalprojectrestoran.dto.CategoryDto;
import springdemo.finalprojectrestoran.model.Category;

import java.util.List;

@Mapper
public interface CategoryMapper {

    CategoryMapper CATEGORY_MAPPER = Mappers.getMapper(CategoryMapper.class);


    @Mapping(target = "products", ignore = true)
    CategoryDto toDto(Category category);
    List<CategoryDto> toDtoList(List<Category> categoryList);

    Category toEntity(CategoryDto categoryDto);
    List<Category> toEntityList(List<CategoryDto> categoryDtoList);

}

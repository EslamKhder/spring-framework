package springdemo.finalprojectrestoran.Service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import springdemo.finalprojectrestoran.Mapper.CategoryMapper;
import springdemo.finalprojectrestoran.Mapper.ProductMapper;
import springdemo.finalprojectrestoran.Repository.CategoryRepository;
import springdemo.finalprojectrestoran.Service.CategoryService;
import springdemo.finalprojectrestoran.Service.ProductService;
import springdemo.finalprojectrestoran.dto.CategoryDto;
import springdemo.finalprojectrestoran.model.Category;
import springdemo.finalprojectrestoran.model.Product;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CategoryServiceImpl implements CategoryService {
    @Autowired
    CategoryRepository categoryRepository;

    @Autowired
    ProductService productService;

    @Override
    public List<CategoryDto> getAllCategory() {
        return CategoryMapper.CATEGORY_MAPPER.toDtoList(categoryRepository.findAll().stream()
                .sorted(Comparator.comparing(Category::getName)) // Sort by name
                .collect(Collectors.toList()));
       /* List<CategoryDto> categoryDtos = CategoryMapper.CATEGORY_MAPPER.toDtoList(categoryRepository.findAll());

        for (CategoryDto categoryDto : categoryDtos) {

            categoryDto.setProducts(ProductMapper.PRODUCT_MAPPER.toEntityList(productService.getProductsByCategoryId(categoryDto.getId())));
        }

        return categoryDtos;*/

    }


}

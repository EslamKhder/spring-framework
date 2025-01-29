package springdemo.finalprojectrestoran.Mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
import springdemo.finalprojectrestoran.dto.ProductDto;
import springdemo.finalprojectrestoran.model.Product;

import java.util.List;

@Mapper
public interface ProductMapper {

    ProductMapper PRODUCT_MAPPER = Mappers.getMapper(ProductMapper.class);

    @Mapping(target = "category", ignore = true)
    @Mapping(target = "order", ignore = true)
    ProductDto toDto(Product product);
    List<ProductDto> toDtoList(List<Product> products);

    Product toEntity(ProductDto productDto);
    List<Product> toEntityList(List<ProductDto> productDtos);
}

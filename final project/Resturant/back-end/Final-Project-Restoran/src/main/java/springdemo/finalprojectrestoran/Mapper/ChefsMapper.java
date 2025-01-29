package springdemo.finalprojectrestoran.Mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
import springdemo.finalprojectrestoran.dto.ChefsDto;
import springdemo.finalprojectrestoran.dto.ProductDto;
import springdemo.finalprojectrestoran.model.Chefs;
import springdemo.finalprojectrestoran.model.Product;

import java.util.List;

@Mapper
public interface ChefsMapper {

    ChefsMapper CHEFS_MAPPER = Mappers.getMapper(ChefsMapper.class);


    ChefsDto toDto(Chefs chefs);
    List<ChefsDto> toDtoList(List<Chefs> chefs);

    Chefs toEntity(ChefsDto chefsDto);
    List<Chefs> toEntityList(List<ChefsDto> chefsDtos);
}

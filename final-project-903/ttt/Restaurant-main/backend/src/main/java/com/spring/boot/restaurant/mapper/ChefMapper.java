package com.spring.boot.restaurant.mapper;

import com.spring.boot.restaurant.dto.ChefDto;
import com.spring.boot.restaurant.model.Chef;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ChefMapper {

    ChefDto toDto(Chef chef);

    Chef toEntity(ChefDto chefDto);

    List<ChefDto> toDtoList(List<Chef> chefs);

    List<Chef> toEntityList(List<ChefDto> chefDtos);
}

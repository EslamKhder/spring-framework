package com.spring.boot.resturantbackend.mappers;

import com.spring.boot.resturantbackend.dto.ChefDto;
import com.spring.boot.resturantbackend.models.Chef;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ChefMapper {
    ChefMapper CHEF_MAPPER = Mappers.getMapper(ChefMapper.class);

    ChefDto toChefDto(Chef chef);
}

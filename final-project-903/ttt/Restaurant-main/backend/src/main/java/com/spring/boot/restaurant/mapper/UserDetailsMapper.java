package com.spring.boot.restaurant.mapper;

import com.spring.boot.restaurant.dto.UserDetailsDto;
import com.spring.boot.restaurant.model.UserDetails;
import org.mapstruct.Mapper;
import java.util.List;

@Mapper(componentModel = "spring")
public interface UserDetailsMapper {

    UserDetailsDto toDto(UserDetails userDetails);

    UserDetails toEntity(UserDetailsDto dto);

    List<UserDetailsDto> toDtoList(List<UserDetails> userDetails);

    List<UserDetails> toEntityList(List<UserDetailsDto> dtos);
}

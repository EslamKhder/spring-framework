package com.spring.demo911.mapper;

import com.spring.demo911.dto.AccountDto;
import com.spring.demo911.dto.RoleDto;
import com.spring.demo911.model.Account;
import com.spring.demo911.model.Roles;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface RoleMapper {

    Roles toEntity(RoleDto roleDto);

    RoleDto toDto(Roles role);

    List<Roles> toEntityList(List<RoleDto> roleDtos);

    List<RoleDto> toDtoList(List<Roles> roles);
}

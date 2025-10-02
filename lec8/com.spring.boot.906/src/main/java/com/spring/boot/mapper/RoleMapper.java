package com.spring.boot.mapper;

import com.spring.boot.dto.RoleDto;
import com.spring.boot.model.Role;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface RoleMapper {

    RoleDto toDto(Role role);
    Role toEntity(RoleDto roleDto);
    List<RoleDto> toListDto(List<Role> roles);
    List<Role> toListEntity(List<RoleDto> roleDtos);

}

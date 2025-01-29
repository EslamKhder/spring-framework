package springdemo.finalprojectrestoran.Mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import springdemo.finalprojectrestoran.dto.Jwt.ClientDto;
import springdemo.finalprojectrestoran.dto.Jwt.RoleDto;
import springdemo.finalprojectrestoran.model.ClientModels.Client;
import springdemo.finalprojectrestoran.model.ClientModels.Role;

import java.util.List;

@Mapper
public interface RoleMapper {
    RoleMapper ROLE_MAPPER = Mappers.getMapper(RoleMapper.class);

    Role toEntity(RoleDto roleDto);

    List<Role> toEntityList(List<RoleDto> roleDtos);
}


package start.group.demo910.mapper;

import org.mapstruct.Mapper;
import start.group.demo910.dto.AccountDto;
import start.group.demo910.dto.RolesDto;
import start.group.demo910.model.Account;
import start.group.demo910.model.Roles;

import java.util.List;

@Mapper(componentModel = "spring")
public interface RolesMapper {

    RolesDto toDto(Roles roles);

    Roles toEntity(RolesDto rolesDto);

    List<RolesDto> toDtoList(List<Roles> roles);

    List<Roles> toEntityList(List<RolesDto> rolesDto);

}
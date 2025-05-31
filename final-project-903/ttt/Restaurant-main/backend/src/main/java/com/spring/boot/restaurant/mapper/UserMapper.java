package com.spring.boot.restaurant.mapper;

import com.spring.boot.restaurant.dto.UserDto;
import com.spring.boot.restaurant.model.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring", uses = {
        UserDetailsMapper.class,
        RoleMapper.class,
        ContactInfoMapper.class
    })
// So you can inject it directly with @Autowired or constructor injection in your Spring services or controllers.
// MapStruct does not automatically know how to map these nested objects unless you tell it.
public interface UserMapper {

    @Mapping(source = "userDetails", target = "userDetails")
    @Mapping(source = "roles", target = "roles")
    UserDto toDto(User user);

    @Mapping(source = "userDetails", target = "userDetails")
    @Mapping(source = "roles", target = "roles")
    User toEntity(UserDto dto);

    List<UserDto> toDtoList(List<User> users);

    List<User> toEntityList(List<UserDto> dtos);

//    @Named("rolesToRoleCodes")
//    default List<RoleCode> rolesToRoleCodes(List<Role> roles) {
//        if (roles == null) return null;
//        return roles.stream().map(Role::getRole).collect(Collectors.toList());
//    }
//
//    @Named("roleCodesToRoles")
//    default List<Role> roleCodesToRoles(List<RoleCode> codes) {
//        if (codes == null) return null;
//        return codes.stream().map(code -> {
//            Role role = new Role();
//            role.setRole(code);
//            return role;
//        }).collect(Collectors.toList());
//    }
}

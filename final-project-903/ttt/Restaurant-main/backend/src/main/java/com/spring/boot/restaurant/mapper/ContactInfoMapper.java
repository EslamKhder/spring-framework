package com.spring.boot.restaurant.mapper;

import com.spring.boot.restaurant.dto.ContactInfoDto;
import com.spring.boot.restaurant.model.ContactInfo;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ContactInfoMapper {
    @Mapping(source = "user.id", target = "userId")
    ContactInfoDto toDto(ContactInfo contactInfo);

    @Mapping(source = "userId", target = "user.id")
    ContactInfo toEntity(ContactInfoDto dto);

    List<ContactInfoDto> toDtoList(List<ContactInfo> list);

    List<ContactInfo> toEntityList(List<ContactInfoDto> list);
}

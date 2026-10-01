package com.spring.boot.resturantbackend.mappers;

import com.spring.boot.resturantbackend.dto.ContactInfoDto;
import com.spring.boot.resturantbackend.models.ContactInfo;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ContactInfoMapper {
    ContactInfoMapper CONTACT_INFO_MAPPER = Mappers.getMapper(ContactInfoMapper.class);

    ContactInfoDto toContactInfoDto(ContactInfo contactInfo);

    ContactInfo toContactInfo(ContactInfoDto contactInfoDto);
}

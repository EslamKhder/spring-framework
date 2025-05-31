package com.spring.boot.restaurant.service;

import com.spring.boot.restaurant.dto.ContactInfoDto;

import java.util.List;

public interface ContactInfoService {
    ContactInfoDto getContactInfo(Long id);
    List<ContactInfoDto> getAllContactInfo();
    ContactInfoDto saveContactInfo(ContactInfoDto dto);
    ContactInfoDto updateContactInfo(Long id, ContactInfoDto dto); // explicit update
    boolean deleteContactInfo(Long id);
}

package com.spring.boot.resturantbackend.services;

import com.spring.boot.resturantbackend.dto.ContactInfoDto;
import jakarta.transaction.SystemException;

public interface ContactInfoService {
    ContactInfoDto createContactInfo(ContactInfoDto contactInfoDto) throws SystemException;
}

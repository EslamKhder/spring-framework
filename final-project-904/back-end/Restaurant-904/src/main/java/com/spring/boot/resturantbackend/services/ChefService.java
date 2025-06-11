package com.spring.boot.resturantbackend.services;

import com.spring.boot.resturantbackend.dto.ChefDto;
import jakarta.transaction.SystemException;

import java.util.List;

public interface ChefService {
    List<ChefDto> getAllChefs() throws SystemException;
}

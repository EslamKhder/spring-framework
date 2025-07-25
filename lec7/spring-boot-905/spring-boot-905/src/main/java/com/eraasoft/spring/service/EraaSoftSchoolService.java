package com.eraasoft.spring.service;

import com.eraasoft.spring.dto.EraaSoftSchoolDto;
import jakarta.transaction.SystemException;

import java.util.List;

public interface EraaSoftSchoolService {
    EraaSoftSchoolDto save(EraaSoftSchoolDto EraaSoftSchoolDto) throws SystemException;
    EraaSoftSchoolDto update(EraaSoftSchoolDto EraaSoftSchoolDto);
    boolean delete(Long id);
    List<EraaSoftSchoolDto> getAll();
    EraaSoftSchoolDto getById(Long id);
    EraaSoftSchoolDto getByUserName(String userName);
}

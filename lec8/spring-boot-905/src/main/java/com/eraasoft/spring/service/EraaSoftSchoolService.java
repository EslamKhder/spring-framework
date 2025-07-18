package com.eraasoft.spring.service;

import com.eraasoft.spring.model.EraaSoftSchool;
import jakarta.transaction.SystemException;

import java.util.List;

public interface EraaSoftSchoolService {
    EraaSoftSchool save(EraaSoftSchool eraaSoftSchool) throws SystemException;
    EraaSoftSchool update(EraaSoftSchool eraaSoftSchool);
    boolean delete(Long id);
    List<EraaSoftSchool> getAll();
    EraaSoftSchool getById(Long id);
    EraaSoftSchool getByUserName(String userName);
}

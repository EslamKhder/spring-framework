package com.eraasoft.spring.service;

import com.eraasoft.spring.model.EraaSoftSchool;

import java.util.List;

public interface EraaSoftSchoolService {
    EraaSoftSchool save(EraaSoftSchool eraaSoftSchool);
    EraaSoftSchool update(EraaSoftSchool eraaSoftSchool);
    boolean delete(Long id);
    List<EraaSoftSchool> getAll();
    EraaSoftSchool getById(Long id);
    EraaSoftSchool getByUserName(String userName);
}

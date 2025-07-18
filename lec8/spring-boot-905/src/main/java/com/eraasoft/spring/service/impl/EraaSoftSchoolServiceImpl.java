package com.eraasoft.spring.service.impl;

import com.eraasoft.spring.model.EraaSoftSchool;
import com.eraasoft.spring.repo.EraaSoftSchoolRepo;
import com.eraasoft.spring.service.EraaSoftSchoolService;
import jakarta.transaction.SystemException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class EraaSoftSchoolServiceImpl implements EraaSoftSchoolService {
    private EraaSoftSchoolRepo eraaSoftSchoolRepo;

    @Autowired
    public EraaSoftSchoolServiceImpl(EraaSoftSchoolRepo eraaSoftSchoolRepo) {
        this.eraaSoftSchoolRepo = eraaSoftSchoolRepo;
    }

    @Override
    public EraaSoftSchool save(EraaSoftSchool eraaSoftSchool) throws SystemException {
        if (Objects.nonNull(eraaSoftSchool.getId())) {
            throw new IndexOutOfBoundsException("id must be null");
        }
        return eraaSoftSchoolRepo.save(eraaSoftSchool); // save not send id on EraaSoftSchool
    }

    @Override
    public EraaSoftSchool update(EraaSoftSchool eraaSoftSchool) {
        if (Objects.isNull(eraaSoftSchool.getId())) {
            throw new RuntimeException("id must be not null");
        }
        return eraaSoftSchoolRepo.save(eraaSoftSchool);// update when send id on EraaSoftSchool
    }

    @Override
    public boolean delete(Long id) {
        Optional<EraaSoftSchool> eraaSoftSchoolOptional = eraaSoftSchoolRepo.findById(id);

        if (!eraaSoftSchoolOptional.isPresent()) {
            return false;
        }

        eraaSoftSchoolRepo.deleteById(id); // true
            return true;
    }

    @Override
    public List<EraaSoftSchool> getAll() {
        return eraaSoftSchoolRepo.findAll();
    }

    @Override
    public EraaSoftSchool getById(Long id) {
        Optional<EraaSoftSchool> eraaSoftSchoolOptional = eraaSoftSchoolRepo.findById(id);

        if (!eraaSoftSchoolOptional.isPresent()) {
            return null;
        }
        return eraaSoftSchoolRepo.getById(id);
    }

    @Override
    public EraaSoftSchool getByUserName(String userName) {
        return eraaSoftSchoolRepo.extractByUserName(userName);
    }
}

package com.eraasoft.spring.service.impl;

import com.eraasoft.spring.mapper.EraaSoftMapper;
import com.eraasoft.spring.model.EraaSoftSchool;
import com.eraasoft.spring.dto.EraaSoftSchoolDto;
import com.eraasoft.spring.repo.EraaSoftSchoolRepo;
import com.eraasoft.spring.service.EraaSoftSchoolService;

import jakarta.transaction.SystemException;
//import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class EraaSoftSchoolServiceImpl implements EraaSoftSchoolService {
    private EraaSoftSchoolRepo eraaSoftSchoolRepo;

    private EraaSoftMapper eraaSoftMapper;

//    private ModelMapper modelMapper;

    @Autowired
    public EraaSoftSchoolServiceImpl(EraaSoftSchoolRepo eraaSoftSchoolRepo, EraaSoftMapper eraaSoftMapper/*, ModelMapper modelMapper*/) {
        this.eraaSoftMapper = eraaSoftMapper;
        this.eraaSoftSchoolRepo = eraaSoftSchoolRepo;
//        this.eraaSoftMapper = eraaSoftMapper;
//        this.modelMapper = modelMapper;
    }

    @Override
    public EraaSoftSchoolDto save(EraaSoftSchoolDto eraaSoftSchoolDto) throws SystemException {
        if (Objects.nonNull(eraaSoftSchoolDto.getId())) {
            throw new RuntimeException("id must be null");
        }

        Optional<EraaSoftSchool> eraaSoftSchoolOp = eraaSoftSchoolRepo.findByUserName(eraaSoftSchoolDto.getFullUserName());

        if (eraaSoftSchoolOp.isPresent()) {
            throw new RuntimeException("user name is exist");
        }

//        EraaSoftSchool eraaSoftSchool = modelMapper.map(eraaSoftSchoolDto, EraaSoftSchool.class);
        EraaSoftSchool eraaSoftSchool = eraaSoftMapper.toEraaSoftSchool(eraaSoftSchoolDto);

        eraaSoftSchool =  eraaSoftSchoolRepo.save(eraaSoftSchool);

        eraaSoftSchoolDto.setId(eraaSoftSchool.getId());

        return eraaSoftSchoolDto; // save not send id on EraaSoftSchoolDto
    }

    @Override
    public EraaSoftSchoolDto update(EraaSoftSchoolDto eraaSoftSchoolDto) {
        if (Objects.isNull(eraaSoftSchoolDto.getId())) {
            throw new RuntimeException("id must be not null");
        }

//        EraaSoftSchool eraaSoftSchool = modelMapper.map(eraaSoftSchoolDto, EraaSoftSchool.class);
        EraaSoftSchool eraaSoftSchool = eraaSoftMapper.toEraaSoftSchool(eraaSoftSchoolDto);

        eraaSoftSchoolRepo.save(eraaSoftSchool);

        return eraaSoftSchoolDto;
    }

    @Override
    public boolean delete(Long id) {
        Optional<EraaSoftSchool> eraaSoftSchool = eraaSoftSchoolRepo.findById(id);

        if (!eraaSoftSchool.isPresent()) {
            return false;
        }

        eraaSoftSchoolRepo.deleteById(id); // true
        return true;
    }

    @Override
    public List<EraaSoftSchoolDto> getAll() {
        List<EraaSoftSchool>  eraaSoftSchools = eraaSoftSchoolRepo.findAll();
        if(CollectionUtils.isEmpty(eraaSoftSchools)){
            return new ArrayList<>();
        }
//
//        return eraaSoftSchools.stream().map(eraaSoftSchool ->
//                modelMapper.map(eraaSoftSchool, EraaSoftSchoolDto.class)).collect(Collectors.toList());

        return eraaSoftSchools.stream().map(eraaSoftSchool -> eraaSoftMapper.toEraaSoftSchoolDto(eraaSoftSchool)).collect(Collectors.toList());
    }

    @Override
    public EraaSoftSchoolDto getById(Long id) {
        Optional<EraaSoftSchool> eraaSoftSchoolOptional = eraaSoftSchoolRepo.findById(id);

        if (!eraaSoftSchoolOptional.isPresent()) {
            return null;
        }

//        return modelMapper.map(eraaSoftSchoolOptional.get(), EraaSoftSchoolDto.class);
        return  eraaSoftMapper.toEraaSoftSchoolDto(eraaSoftSchoolOptional.get());
    }

    @Override
    public EraaSoftSchoolDto getByUserName(String userName) {
        Optional<EraaSoftSchool> eraaSoftSchoolOptional = eraaSoftSchoolRepo.extractByUserName(userName);
        if (!eraaSoftSchoolOptional.isPresent()) {
            return null;
        }
//        return modelMapper.map(eraaSoftSchoolOptional.get(), EraaSoftSchoolDto.class);
        return eraaSoftMapper.toEraaSoftSchoolDto(eraaSoftSchoolOptional.get());
    }
}

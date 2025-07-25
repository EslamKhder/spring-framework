package com.eraasoft.spring.mapper;

import com.eraasoft.spring.dto.EraaSoftSchoolDto;
import com.eraasoft.spring.model.EraaSoftSchool;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

// EraaSoftSchool   EraaSoftSchoolDto
@Mapper
public interface EraaSoftMapper {

    EraaSoftMapper ERAA_SOFT_MAPPER = Mappers.getMapper(EraaSoftMapper.class);

    @Mapping(source = "fullUserName", target = "userName")
    EraaSoftSchool toEraaSoftSchool(EraaSoftSchoolDto eraaSoftSchoolDto);
    @Mapping(source = "userName", target = "fullUserName")
    EraaSoftSchoolDto toEraaSoftSchoolDto(EraaSoftSchool EraaSoftSchool);
    List<EraaSoftSchool> toEraaSoftSchoolList(List<EraaSoftSchoolDto> eraaSoftSchoolDtos);
    List<EraaSoftSchoolDto> toEraaSoftSchoolDtoList(List<EraaSoftSchool> eraaSoftSchools);
}

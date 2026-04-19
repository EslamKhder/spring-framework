package com.spring.demo.mapper;

import com.spring.demo.dto.TeacherDto;
import com.spring.demo.model.Teacher;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface TeacherMapper {


    @Mapping(source = "fullAddress", target = "address")
    Teacher toEntity(TeacherDto teacherDto);

    @Mapping(source = "address", target = "fullAddress")
    @Mapping(target = "password", ignore = true)
    TeacherDto toDto(Teacher teacher);

    List<Teacher> toEntityList(List<TeacherDto> teacherDtos);
    List<TeacherDto> toDtoList(List<Teacher> teachers);

}

package com.spring.mapper;

import com.spring.dto.TeacherDto;
import com.spring.model.Teacher;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface TeacherMapper {

    TeacherMapper teacherMapper = Mappers.getMapper(TeacherMapper.class);

//    @Mapping(target = "students", ignore = true)
    Teacher toEntity(TeacherDto teacherDto);

    @Mapping(target = "students", ignore = true)
    TeacherDto toDto(Teacher teacher);

    List<TeacherDto> toDtoList(List<Teacher> teachers);

    List<Teacher> toEntityList(List<TeacherDto> teachers);
}

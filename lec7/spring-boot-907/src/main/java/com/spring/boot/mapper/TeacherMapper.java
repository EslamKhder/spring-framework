package com.spring.boot.mapper;

import com.spring.boot.dto.TeacherDto;
import com.spring.boot.model.Teacher;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring", uses = RoleMapper.class)
public interface TeacherMapper {

    @Mapping(source = "myName", target = "name")
//    @Mapping(target = "id", ignore = true)
    Teacher toEntity(TeacherDto teacherDto); //update

    @Mapping(source = "name", target = "myName")
    @Mapping(target = "id", ignore = true)
    TeacherDto toDto(Teacher teacher);

    List<Teacher> toEntityList(List<TeacherDto> teacherDto);

    List<TeacherDto> toDtoList(List<Teacher> teacher);

}

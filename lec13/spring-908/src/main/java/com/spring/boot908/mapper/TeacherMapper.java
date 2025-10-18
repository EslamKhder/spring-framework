package com.spring.boot908.mapper;

import com.spring.boot908.dto.TeacherDto;
import com.spring.boot908.model.Teacher;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

// teacher
// teacherDto
@Mapper(componentModel = "spring")
public interface TeacherMapper {

    @Mapping(source = "teacherId", target = "id")
    Teacher toEntity(TeacherDto teacherDto);

    @Mapping(source = "id", target = "teacherId")
//    @Mapping(target = "password", ignore = true)
    TeacherDto toDto(Teacher teacher);

    List<Teacher> toEntityList(List<TeacherDto> teacherDto);

    List<TeacherDto> toDto(List<Teacher> teacher);
}

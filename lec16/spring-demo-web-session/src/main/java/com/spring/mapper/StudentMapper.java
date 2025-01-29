package com.spring.mapper;

import com.spring.dto.StudentDto;
import com.spring.model.Student;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface StudentMapper {

    StudentMapper studentMapper = Mappers.getMapper(StudentMapper.class);

    Student toEntity(StudentDto studentDto);

    @Mapping(target = "teacher", ignore = true)
    StudentDto toDto(Student student);
    List<StudentDto> toDtoList(List<Student> students);
    List<Student> toEntityList(List<StudentDto> students);
}

package com.boot.start.service.mapper;

import com.boot.start.dto.StudentDto;
import com.boot.start.model.Student;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface StudentMapper {

    StudentMapper STUDENT_MAPPER = Mappers.getMapper(StudentMapper.class);

    StudentDto toDto(Student student);
    Student toEntity(StudentDto studentDto);
    List<StudentDto> toDtoList(List<Student> students);
    List<Student>toEntityList(List<StudentDto> studentDtoList);
}

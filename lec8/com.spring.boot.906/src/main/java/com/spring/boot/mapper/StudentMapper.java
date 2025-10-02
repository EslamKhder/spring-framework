package com.spring.boot.mapper;

import com.spring.boot.dto.StudentDto;
import com.spring.boot.model.Student;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring", uses = {RoleMapper.class})
public interface StudentMapper {

    StudentDto toDto(Student student);
    Student toEntity(StudentDto studentDto);
    List<StudentDto> toListDto(List<Student> students);
    List<Student> toListEntity(List<StudentDto> studentDto);

}

package com.spring.service;

import com.spring.dto.TeacherDto;

import java.util.List;

public interface TeacherService {

    List<TeacherDto> getAllTeacher();

    List<TeacherDto> getTeacherWithStudents();

    TeacherDto getTeacherByIdWithStudent(Long id);
    TeacherDto getTeacherById(Long id);

    void saveListOfTeacher(List<TeacherDto> teachers);

    void saveTeacherWithListOfStudents(TeacherDto teacher);
}

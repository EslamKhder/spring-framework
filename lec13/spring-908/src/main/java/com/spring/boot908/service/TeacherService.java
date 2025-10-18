package com.spring.boot908.service;

import com.spring.boot908.dto.TeacherDto;

import java.util.List;

public interface TeacherService {

    List<TeacherDto> getAllTeachers();

    TeacherDto saveTeacher(TeacherDto teacherDto);

    TeacherDto updateTeacher(TeacherDto teacherDto);

    void deleteTeacher(Long id);

    TeacherDto getTeacherById(Long id);
    TeacherDto getTeacherByUserName(String userName);
}

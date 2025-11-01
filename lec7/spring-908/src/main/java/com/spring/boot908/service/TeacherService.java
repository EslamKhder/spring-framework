package com.spring.boot908.service;

import com.spring.boot908.dto.TeacherDto;
import jakarta.transaction.SystemException;

import java.util.List;

public interface TeacherService {

    List<TeacherDto> getAllTeachers();

    TeacherDto saveTeacher(TeacherDto teacherDto) throws SystemException;

    TeacherDto updateTeacher(TeacherDto teacherDto);

    void deleteTeacher(Long id);

    TeacherDto getTeacherById(Long id);
    TeacherDto getTeacherByUserName(String userName);
}

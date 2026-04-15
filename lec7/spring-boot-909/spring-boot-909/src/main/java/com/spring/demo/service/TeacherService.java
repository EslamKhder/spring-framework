package com.spring.demo.service;

import com.spring.demo.dto.TeacherDto;
import jakarta.transaction.SystemException;

import java.util.List;

public interface TeacherService {

    TeacherDto createTeacher(TeacherDto teacherDto) throws SystemException;
    TeacherDto updateTeacher(TeacherDto teacherDto) throws SystemException;
    TeacherDto getTeacherById(Long id);
    List<TeacherDto> getTeachers();
    void removeTeacherById(Long id);

    TeacherDto getTeacherByUserName(String userName);
    List<TeacherDto> findByFirstNameStartingWithOrderByFirstNameDesc(String firstName);
}

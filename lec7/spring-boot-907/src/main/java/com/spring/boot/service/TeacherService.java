package com.spring.boot.service;

import com.spring.boot.dto.TeacherDto;
import jakarta.transaction.SystemException;

import java.util.List;

public interface TeacherService {


    List<TeacherDto> findTeachers();
    TeacherDto addTeacher(TeacherDto teacherDto);
    TeacherDto editTeacher(TeacherDto teacherDto);

    void removeTeacher(Long id);

    TeacherDto getByUserName(String userName) throws SystemException;

    TeacherDto getById(Long id) throws SystemException;
}

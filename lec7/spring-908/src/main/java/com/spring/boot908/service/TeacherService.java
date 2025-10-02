package com.spring.boot908.service;

import com.spring.boot908.model.Teacher;

import java.util.List;

public interface TeacherService {

    List<Teacher> getAllTeachers();

    Teacher saveTeacher(Teacher teacher);

    Teacher updateTeacher(Teacher teacher);

    void deleteTeacher(Long id);

    Teacher getTeacherById(Long id);
}

package com.spring.boot.service;

import com.spring.boot.model.Teacher;

import java.util.List;

public interface TeacherService {


    List<Teacher> findTeachers();
    Teacher addTeacher(Teacher teacher);
    Teacher editTeacher(Teacher teacher);

    void removeTeacher(Long id);
}

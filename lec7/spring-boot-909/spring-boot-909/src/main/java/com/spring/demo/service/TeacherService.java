package com.spring.demo.service;

import com.spring.demo.model.Teacher;
import jakarta.transaction.SystemException;

import java.util.List;

public interface TeacherService {

    Teacher createTeacher(Teacher teacher) throws SystemException;
    Teacher updateTeacher(Teacher teacher) throws SystemException;
    Teacher getTeacherById(Long id);
    List<Teacher> getTeachers();
    void removeTeacherById(Long id);

    Teacher getTeacherByUserName(String userName);
    List<Teacher> findByFirstNameStartingWithOrderByFirstNameDesc(String firstName);
}

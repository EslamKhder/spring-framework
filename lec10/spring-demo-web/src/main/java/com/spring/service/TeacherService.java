package com.spring.service;

import com.spring.dto.StudentDto;
import com.spring.dto.TeacherDto;
import com.spring.model.Student;
import com.spring.model.Teacher;
import jakarta.transaction.SystemException;

import java.util.List;

public interface TeacherService {

    List<TeacherDto> getAllTeacher();
}

package com.spring.boot.service;

import com.spring.boot.dto.StudentDto;
import jakarta.transaction.SystemException;

import java.util.List;

public interface StudentService {

    StudentDto saveStudent(StudentDto StudentDto) throws SystemException;
    StudentDto updateStudent(StudentDto StudentDto) throws SystemException;
    void removeStudentById(Long id) throws SystemException;
    StudentDto getStudentById(Long id) throws SystemException;
    List<StudentDto> getStudents();
    List<StudentDto> getStudentsByName(String name) throws SystemException;
    StudentDto getStudentsByUserName(String useName);
}

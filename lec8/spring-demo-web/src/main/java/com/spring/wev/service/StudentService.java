package com.spring.wev.service;

import com.spring.wev.dto.StudentDto;
import com.spring.wev.model.Student;
import jakarta.transaction.SystemException;

import java.util.List;

public interface StudentService {

    void addStudent(StudentDto student) throws SystemException;

    Student getStudentById(Long id);
    void removeStudentById(Long id);

    void updateStudent(Student student);

    List<StudentDto> getAllStudent();

    List<Student> getStudentLikeLetter(String letters);
    List<Student> getStudentByName(String name);
    List<Student> getStudentByAge(int age);
}

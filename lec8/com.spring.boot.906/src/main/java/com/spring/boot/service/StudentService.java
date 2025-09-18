package com.spring.boot.service;

import com.spring.boot.model.Student;

import java.util.List;

public interface StudentService {

    Student saveStudent(Student student);
    Student updateStudent(Student student);
    void removeStudentById(Long id);
    Student getStudentById(Long id);
    List<Student> getStudents();
}

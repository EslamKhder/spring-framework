package com.boot.start.service;

import com.boot.start.model.Student;
import jakarta.transaction.SystemException;

import java.util.List;

public interface StudentService {

    Student saveStudent(Student student) throws SystemException;
    Student updateStudent(Student student) throws SystemException;
    void deleteStudent(Integer studentId) throws SystemException;
    List<Student> getStudents();
    List<Student> getStudentByName(String name);

}

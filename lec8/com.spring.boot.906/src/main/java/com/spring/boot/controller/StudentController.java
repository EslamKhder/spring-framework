package com.spring.boot.controller;

import com.spring.boot.model.Student;
import com.spring.boot.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class StudentController {

    @Autowired
    private StudentService studentService;

    // http://localhost:8080/students
    @GetMapping("/students")
    public List<Student> getAllStudent(){
        return studentService.getStudents();
    }



}

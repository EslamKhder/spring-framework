package com.spring.boot.controller;

import com.spring.boot.StudentDto.StudentDto;
import com.spring.boot.service.StudentService;
import jakarta.transaction.SystemException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class StudentController {

    @Autowired
    private StudentService studentService;

    // http://localhost:8080/students
    @GetMapping("/students")
    public List<StudentDto> getAllStudent(){
        return studentService.getStudents();
    }

    // http://localhost:8080/students
    @GetMapping("/students/name/{name}")
    public List<StudentDto> getStudentByName(@PathVariable String name) throws SystemException {
        return studentService.getStudentsByName(name);
    }

    // http://localhost:8080/students
    @GetMapping("/students/id/{id}")
    public StudentDto getStudentById(@PathVariable Long id) throws SystemException {
        return studentService.getStudentById(id);
    }

    @PostMapping("/add")
    public StudentDto addStudent(@RequestBody StudentDto studentDto) throws SystemException {
        return studentService.saveStudent(studentDto);
    }

    @PutMapping("/update")
    public StudentDto updateStudent(@RequestBody StudentDto studentDto) throws SystemException {
        return studentService.updateStudent(studentDto);
    }

    // http://localhost:8080/delete?id-param=1
//    @DeleteMapping("/delete")
//    public void deleteStudent(@RequestParam("id-param") Long id){
    @DeleteMapping("/delete/id/{id}")
    public void deleteStudent(@PathVariable Long id) throws SystemException {
        studentService.removeStudentById(id);
    }

}

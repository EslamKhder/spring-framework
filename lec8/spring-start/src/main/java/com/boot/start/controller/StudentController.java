package com.boot.start.controller;

import com.boot.start.model.Student;
import com.boot.start.service.StudentService;
import jakarta.transaction.SystemException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/student")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @PostMapping("/save")
    ResponseEntity<Student> saveStudent(@RequestBody Student student) throws SystemException {
        return ResponseEntity.ok(studentService.saveStudent(student));
    }

    @PutMapping("/update")
    ResponseEntity<Student> updateStudent(@RequestBody Student student) throws SystemException {
        return ResponseEntity.ok(studentService.updateStudent(student));
    }

    @DeleteMapping("/delete/v1")
    ResponseEntity<Void> deleteStudent(@RequestParam("studentId") Integer id) throws SystemException {
        studentService.deleteStudent(id);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/delete/v2/{studentId}/{number}")
    ResponseEntity<Void> deleteStudentV2(@PathVariable("studentId") Integer id) throws SystemException {
        studentService.deleteStudent(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping
    ResponseEntity<List<Student>> getAllStudent(){
        return ResponseEntity.ok(studentService.getStudents());
    }

    // TODO send name of student   please return the related student

    @GetMapping("/get-student-by-name")
    ResponseEntity<List<Student>> getStudentByName(String name){
        return ResponseEntity.ok(studentService.getStudentByName(name));
    }

    // TODO   get students that name strat with ah char
    // TODO   get students that name end with mi char
    // TODO   get students that name contain ed char

    // TODO   create api to save listOfStudent
    // TODO   create api to delete listOfStudentIDS
    // TODO   create api to update listOfStudent
}

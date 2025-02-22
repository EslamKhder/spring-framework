package com.spring.wev.controller;

import com.spring.wev.dto.StudentDto;
import com.spring.wev.model.Student;
import com.spring.wev.service.StudentService;
import jakarta.transaction.SystemException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

// http://localhost:9090/student
@RestController
@RequestMapping("/student")
public class StudentController {

    @Autowired
    private StudentService studentService;

    // http://localhost:9090/student/addSudent
    @PostMapping("/addSudent")
    ResponseEntity<Void> addStudent(@Validated @RequestBody StudentDto student) throws SystemException {
        studentService.addStudent(student);
        return ResponseEntity.created(URI.create("/student/addSudent")).build();
    }

    // http://localhost:9090/student/getStudent?studentId=5
    // http://localhost:9090/student/getStudent/5
//    @GetMapping("/getStudent/{idStudent}")
//    @GetMapping("/getStudent/{idStudent}")
//    Student addStudent(@PathVariable("idStudent") Long id){
    @GetMapping("/getStudent")
    ResponseEntity<Student> getStudent(@RequestParam("studentId") Long id){
//        return ResponseEntity.ok(studentService.getStudentById(id));
        return ResponseEntity.ok().body(studentService.getStudentById(id));
    }

    // http://localhost:9090/student/deleteStudent?id=5
    @DeleteMapping("/deleteStudent")
    ResponseEntity<Void> deleteStudentById(@RequestParam Long id){
        studentService.removeStudentById(id);
        return ResponseEntity.noContent().build();
    }

    // http://localhost:9090/student/updateSudent
    @PutMapping("/updateSudent")
    void updateStudent(@RequestBody StudentDto student) throws SystemException {
        studentService.addStudent(student);
    }

    @GetMapping("/allStudent")
    ResponseEntity<List<StudentDto>> getAllStudent(){
        return ResponseEntity.ok(studentService.getAllStudent());
    }

    @GetMapping("/allStudentByName")
    List<Student> getAllStudentByName(@RequestParam String name){
        return studentService.getStudentByName(name);
    }

    @GetMapping("/allStudentByNameContains")
    List<Student> getAllStudentByNameContains(@RequestParam String letters){
        return studentService.getStudentLikeLetter(letters);
    }

    @GetMapping("/allStudentByAge")
    List<Student> getAllStudentByAge(@RequestParam int age){
        return studentService.getStudentByAge(age);
    }
}

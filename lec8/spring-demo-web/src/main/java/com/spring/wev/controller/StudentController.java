package com.spring.wev.controller;

import com.spring.wev.dto.StudentDto;
import com.spring.wev.model.Student;
import com.spring.wev.service.StudentService;
import jakarta.transaction.SystemException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

// http://localhost:9090/student
@RestController
@RequestMapping("/student")
public class StudentController {

    @Autowired
    private StudentService studentService;

    // http://localhost:9090/student/addSudent
    @PostMapping("/addSudent")
    void addStudent(@RequestBody StudentDto student) throws SystemException {
        studentService.addStudent(student);
    }

    // http://localhost:9090/student/getStudent?studentId=5
    // http://localhost:9090/student/getStudent/5
//    @GetMapping("/getStudent/{idStudent}")
//    @GetMapping("/getStudent/{idStudent}")
//    Student addStudent(@PathVariable("idStudent") Long id){
    @GetMapping("/getStudent")
    Student getStudent(@RequestParam("studentId") Long id){
        return studentService.getStudentById(id);
    }

    // http://localhost:9090/student/deleteStudent?id=5
    @DeleteMapping("/deleteStudent")
    String deleteStudentById(@RequestParam Long id){
        studentService.removeStudentById(id);
        return "Success Deleted";
    }

    // http://localhost:9090/student/updateSudent
    @PutMapping("/updateSudent")
    void updateStudent(@RequestBody StudentDto student) throws SystemException {
        studentService.addStudent(student);
    }

    @GetMapping("/allStudent")
    List<StudentDto> getAllStudent(){
        return studentService.getAllStudent();
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

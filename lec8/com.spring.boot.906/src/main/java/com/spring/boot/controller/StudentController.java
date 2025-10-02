package com.spring.boot.controller;

import com.spring.boot.dto.StudentDto;
import com.spring.boot.service.StudentService;
import jakarta.transaction.SystemException;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api-student")
public class StudentController {

    @Autowired
    private StudentService studentService;

    // http://localhost:8080/students
    @GetMapping("/students")
    public ResponseEntity<List<StudentDto>> getAllStudent(){
        return ResponseEntity.ok().body(studentService.getStudents());
    }

    // api size students    List student    avg grade

    // http://localhost:8080/students
    @GetMapping("/students/name/{name}")
    public ResponseEntity<List<StudentDto>> getStudentByName(@PathVariable String name) throws SystemException {
        return ResponseEntity.ok().body(studentService.getStudentsByName(name));
    }

    // http://localhost:8080/students
    @GetMapping("/students/id/{id}")
    public ResponseEntity<StudentDto> getStudentById(@PathVariable Long id) throws SystemException {
        return ResponseEntity.ok(studentService.getStudentById(id));
    }

    @PostMapping("/add")
    public ResponseEntity<StudentDto> addStudent(@RequestBody @Valid StudentDto studentDto) throws SystemException {
        return ResponseEntity.created(URI.create("/add")).body(studentService.saveStudent(studentDto));
    }

    @PutMapping("/update")
    public ResponseEntity<StudentDto> updateStudent(@RequestBody StudentDto studentDto) throws SystemException {
        return ResponseEntity.ok(studentService.updateStudent(studentDto));
    }

    // http://localhost:8080/delete?id-param=1
//    @DeleteMapping("/delete")
//    public void deleteStudent(@RequestParam("id-param") Long id){
    @DeleteMapping("/delete/id/{id}")
    public ResponseEntity<Void> deleteStudent(@PathVariable Long id) throws SystemException {
        studentService.removeStudentById(id);
        return ResponseEntity.noContent().build();
    }

}

package com.spring.controller;

import com.spring.dto.StudentDto;
import com.spring.dto.TeacherDto;
import com.spring.model.Teacher;
import com.spring.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

// http://localhost:9090/teacher
@RestController
@RequestMapping("/teacher")
public class TeacherController {

    @Autowired
    private TeacherService teacherService;

    @GetMapping("/allTeacher")
    ResponseEntity<List<TeacherDto>> getAllStudent(){
        return ResponseEntity.ok(teacherService.getAllTeacher());
    }


}

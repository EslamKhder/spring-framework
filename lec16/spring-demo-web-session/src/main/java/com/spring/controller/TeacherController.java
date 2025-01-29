package com.spring.controller;

import com.spring.dto.StudentDto;
import com.spring.dto.TeacherDto;
import com.spring.model.Teacher;
import com.spring.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
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

    @GetMapping("/allTeacherWithStudents")
    ResponseEntity<List<TeacherDto>> getAllTeacherWithStudents(){
        return ResponseEntity.ok(teacherService.getTeacherWithStudents());
    }

    @GetMapping("/teacherWithStudents/{id}")
    ResponseEntity<TeacherDto> getTeacherWithStudents(@PathVariable Long id){
        return ResponseEntity.ok(teacherService.getTeacherByIdWithStudent(id));
    }


    @PostMapping("/saveTeachers")
    ResponseEntity<Void> saveTeachers( @RequestBody List<TeacherDto> teacherDtos){
        teacherService.saveListOfTeacher(teacherDtos);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/saveTeacherWithStudents")
    ResponseEntity<Void> saveTeacherWithListOfStudents(@RequestBody TeacherDto teacherDto){
        teacherService.saveTeacherWithListOfStudents(teacherDto);
        return ResponseEntity.ok().build();
    }
}

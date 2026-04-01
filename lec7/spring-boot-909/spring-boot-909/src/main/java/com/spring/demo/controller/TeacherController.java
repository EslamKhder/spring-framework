package com.spring.demo.controller;

import com.spring.demo.model.Teacher;
import com.spring.demo.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TeacherController {

    private TeacherService teacherService;

    @Autowired
    public TeacherController(TeacherService teacherService) {
        this.teacherService = teacherService;
    }

    @PostMapping("/save")
    public Teacher createTeacher(Teacher teacher){
        return teacherService.createTeacher(teacher);
    }


    @PutMapping("/update")
    public Teacher updateTeacher(Teacher teacher){
        return teacherService.updateTeacher(teacher);
    }

    @GetMapping("/teachers")
    public List<Teacher> getAllTeachers(){
        return teacherService.getTeachers();
    }

    @GetMapping("/teachers/id")
    public Teacher getTeacherById(Long id){
        return teacherService.getTeacherById(id);
    }

    @DeleteMapping("/teachers/id")
    public void removeTeacherById(Long id){
        teacherService.removeTeacherById(id);
    }

}

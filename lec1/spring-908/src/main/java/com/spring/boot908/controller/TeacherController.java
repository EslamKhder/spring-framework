package com.spring.boot908.controller;

import com.spring.boot908.model.Teacher;
import com.spring.boot908.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TeacherController {

    private TeacherService teacherService;

    @Autowired
    public TeacherController(TeacherService teacherService) {
        this.teacherService = teacherService;
    }

    @GetMapping("/teachers")
    public List<Teacher> getTeacher(){
        return teacherService.getAllTeachers();
    }

    @PostMapping("/teacher/save")
    public Teacher saveTeacher(Teacher teacher){
        return teacherService.saveTeacher(teacher);
    }


    @PutMapping("/teacher/update")
    public Teacher updateTeacher(Teacher teacher){
        return teacherService.updateTeacher(teacher);
    }

    @DeleteMapping("/teacher/delete")
    public void deleteTeacher(Long id){
        teacherService.deleteTeacher(id);
    }

    @GetMapping("/teacher")
    public Teacher getTeacher(Long id){
        return teacherService.getTeacherById(id);
    }

}

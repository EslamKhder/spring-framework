package com.spring.boot.controller;

import com.spring.boot.model.Teacher;
import com.spring.boot.service.TeacherService;
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

    @GetMapping("/teachers")
    public List<Teacher> getAllTeachers(){
        return teacherService.findTeachers();
    }

    @PostMapping("/save/teacher")
    public Teacher saveTeacher(@RequestBody Teacher teacher){
        return teacherService.addTeacher(teacher);
    }

    @PutMapping("/edit/teacher")
    public Teacher editTeacher(@RequestBody Teacher teacher){
        return teacherService.editTeacher(teacher);
    }

    // request param
//    @DeleteMapping("/delete/teacher")//?teacherId=55
//    public void removeTeacher(@RequestParam("teacherId") Long id){
//        teacherService.removeTeacher(id);
//    }

//    @DeleteMapping("/delete/teacher/{id}")
//    public void removeTeacher(@PathVariable Long id){
//        teacherService.removeTeacher(id);
//    }

    @DeleteMapping("/delete/teacher")
    public void removeTeacher(@RequestBody Teacher teacher){
        teacherService.removeTeacher(teacher.getId());
    }

    // find teacher by id


}

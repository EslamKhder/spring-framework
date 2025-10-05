package com.spring.boot908.controller;

import com.spring.boot908.dto.TeacherDto;
import com.spring.boot908.service.TeacherService;
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
    public List<TeacherDto> getTeacher(){
        return teacherService.getAllTeachers();
    }

    @PostMapping("/teacher/save")
    public TeacherDto saveTeacher(@RequestBody TeacherDto teacherDto){
        return teacherService.saveTeacher(teacherDto);
    }

    @PutMapping("/teacher/update")
    public TeacherDto updateTeacher(@RequestBody TeacherDto teacherDto){
        return teacherService.updateTeacher(teacherDto);
    }


    // http://localhost:9090/teacher/delete/5   path_variable

    // http://localhost:9090/teacher/delete?id=5   param
    // http://localhost:9090/teacher/delete?teacherId=5   param
//    @DeleteMapping("/teacher/delete")
//    public void deleteTeacher(@RequestParam("teacherId") Long id){
//        teacherService.deleteTeacher(id);
//    }

    // http://localhost:9090/teacher/delete/5
    @DeleteMapping("/teacher/delete/{teacherId}")
    public void deleteTeacher(@PathVariable("teacherId") Long id){
        teacherService.deleteTeacher(id);
    }

    @GetMapping("/teacher")
    public TeacherDto getTeacher(@RequestParam("teacherId") Long id){
        return teacherService.getTeacherById(id);
    }


    @GetMapping("/teacher/username")
    public TeacherDto getTeacher(@RequestParam String userName){
        return teacherService.getTeacherByUserName(userName);
    }
}

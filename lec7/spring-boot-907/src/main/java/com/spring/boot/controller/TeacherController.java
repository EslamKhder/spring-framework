package com.spring.boot.controller;

import com.spring.boot.dto.TeacherDto;
import com.spring.boot.service.TeacherService;
import jakarta.transaction.SystemException;
import jakarta.validation.Valid;
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
    public List<TeacherDto> getAllTeachers(){
        return teacherService.findTeachers();
    }

    @PostMapping("/save/teacher")
    public TeacherDto saveTeacher(@RequestBody @Valid TeacherDto teacherDto){
        return teacherService.addTeacher(teacherDto);
    }

    @PutMapping("/edit/teacher")
    public TeacherDto editTeacher(@RequestBody @Valid TeacherDto teacherDto){
        return teacherService.editTeacher(teacherDto);
    }

    @DeleteMapping("/delete/teacher")
    public void removeTeacher(@RequestBody TeacherDto teacherDto){
        teacherService.removeTeacher(teacherDto.getId());
    }

    @GetMapping("/teacher")
    public TeacherDto getTeacherByUserName(@RequestParam String userName) throws SystemException {
        return teacherService.getByUserName(userName);
    }

    @GetMapping("/teacher/{id}")
    public TeacherDto getTeacherById(@PathVariable Long id) throws SystemException {
        return teacherService.getById(id);
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


}

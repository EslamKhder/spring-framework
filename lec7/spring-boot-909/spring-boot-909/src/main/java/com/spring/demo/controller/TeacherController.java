package com.spring.demo.controller;

import com.spring.demo.dto.TeacherDto;
import com.spring.demo.service.TeacherService;
import jakarta.transaction.SystemException;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class TeacherController {

    private TeacherService teacherService;

    @Autowired
    public TeacherController(TeacherService teacherService) {
        this.teacherService = teacherService;
    }

    @PostMapping("/save")
    public TeacherDto createTeacher(@RequestBody @Valid TeacherDto teacherDto) throws SystemException {
        return teacherService.createTeacher(teacherDto);
    }


    @PutMapping("/update")
    public TeacherDto updateTeacher(@RequestBody TeacherDto teacherDto) throws SystemException {
        return teacherService.updateTeacher(teacherDto);
    }

    // http://localhost:9091/teachers
    @GetMapping("/teachers")
    public List<TeacherDto> getAllTeachers(){
        return teacherService.getTeachers();
    }


    // http://localhost:9091/teacher
    //pathV http://localhost:9091/teacher/id/5
    //@GetMapping("/teachers/id/{id}")

    // param http://localhost:9091/teacher
    @GetMapping("/teacher")
    public TeacherDto getTeacherById(@RequestParam(value = "id") Long id){
        return teacherService.getTeacherById(id);
    }

    //pathV http://localhost:9091/teachers/id
    @DeleteMapping("/teachers/id/{id}")
    public void removeTeacherById(@PathVariable Long id){
        teacherService.removeTeacherById(id);
    }

    @GetMapping("/teacher/username")
    public TeacherDto getTeacherById(@RequestParam(value = "username") String username){
        return teacherService.getTeacherByUserName(username);
    }

    @GetMapping("/teacher/firstName")
    public List<TeacherDto> findByFirstNameStartingWithOrderByFirstNameDesc(@RequestParam(value = "firstName") String firstName){
        return teacherService.findByFirstNameStartingWithOrderByFirstNameDesc(firstName);
    }
}

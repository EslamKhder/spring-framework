package com.spring.demo.controller;

import com.spring.demo.model.Teacher;
import com.spring.demo.service.TeacherService;
import jakarta.transaction.SystemException;
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
    public Teacher createTeacher(@RequestBody Teacher teacher) throws SystemException {
        return teacherService.createTeacher(teacher);
    }


    @PutMapping("/update")
    public Teacher updateTeacher(@RequestBody Teacher teacher) throws SystemException {
        return teacherService.updateTeacher(teacher);
    }

    // http://localhost:9091/teachers
    @GetMapping("/teachers")
    public List<Teacher> getAllTeachers(){
        return teacherService.getTeachers();
    }


    // http://localhost:9091/teacher
    //pathV http://localhost:9091/teacher/id/5
    //@GetMapping("/teachers/id/{id}")

    // param http://localhost:9091/teacher
    @GetMapping("/teacher")
    public Teacher getTeacherById(@RequestParam(value = "id") Long id){
        return teacherService.getTeacherById(id);
    }

    //pathV http://localhost:9091/teachers/id
    @DeleteMapping("/teachers/id/{id}")
    public void removeTeacherById(@PathVariable Long id){
        teacherService.removeTeacherById(id);
    }

    @GetMapping("/teacher/username")
    public Teacher getTeacherById(@RequestParam(value = "username") String username){
        return teacherService.getTeacherByUserName(username);
    }

    @GetMapping("/teacher/firstName")
    public List<Teacher> findByFirstNameStartingWithOrderByFirstNameDesc(@RequestParam(value = "firstName") String firstName){
        return teacherService.findByFirstNameStartingWithOrderByFirstNameDesc(firstName);
    }
}

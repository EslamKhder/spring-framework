package com.spring.demo.controller;

import com.spring.demo.dto.TeacherDto;
import com.spring.demo.service.TeacherService;
import jakarta.transaction.SystemException;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
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
    public ResponseEntity<TeacherDto> createTeacher(@RequestBody @Valid TeacherDto teacherDto) throws SystemException, URISyntaxException {
        return ResponseEntity.created(new URI("/api/save")).body(teacherService.createTeacher(teacherDto));
//        return teacherService.createTeacher(teacherDto);
    }


    @PutMapping("/update")
    public ResponseEntity<TeacherDto> updateTeacher(@RequestBody TeacherDto teacherDto) throws SystemException {
        return ResponseEntity.ok(teacherService.updateTeacher(teacherDto));
//        return teacherService.updateTeacher(teacherDto);
    }

    // http://localhost:9091/teachers
    @GetMapping("/teachers")
    public ResponseEntity<List<TeacherDto>> getAllTeachers(){
        return ResponseEntity.ok(teacherService.getTeachers());
        //return teacherService.getTeachers();
    }


    // http://localhost:9091/teacher
    //pathV http://localhost:9091/teacher/id/5
    //@GetMapping("/teachers/id/{id}")

    // param http://localhost:9091/teacher
    @GetMapping("/teacher")
    public ResponseEntity<TeacherDto> getTeacherById(@RequestParam(value = "id") Long id){
        return ResponseEntity.ok(teacherService.getTeacherById(id));
        //return teacherService.getTeacherById(id);
    }

    //pathV http://localhost:9091/teachers/id
    @DeleteMapping("/teachers/id/{id}")
    public ResponseEntity<Void> removeTeacherById(@PathVariable Long id){
        teacherService.removeTeacherById(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/teacher/username")
    public ResponseEntity<TeacherDto> getTeacherById(@RequestParam(value = "username") String username) throws SystemException {
        return ResponseEntity.ok(teacherService.getTeacherByUserName(username));
//        return teacherService.getTeacherByUserName(username);
    }

    @GetMapping("/teacher/firstName")
    public ResponseEntity<List<TeacherDto>> findByFirstNameStartingWithOrderByFirstNameDesc(@RequestParam(value = "firstName") String firstName){
        return ResponseEntity.ok(teacherService.findByFirstNameStartingWithOrderByFirstNameDesc(firstName));
//        return teacherService.findByFirstNameStartingWithOrderByFirstNameDesc(firstName);
    }
}

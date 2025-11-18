package com.spring.boot.controller;

import com.spring.boot.dto.TeacherDto;
import com.spring.boot.service.TeacherService;
import jakarta.transaction.SystemException;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

@RestController
public class TeacherController {

    private TeacherService teacherService;

    @Autowired
    public TeacherController(TeacherService teacherService) {
        this.teacherService = teacherService;
    }

    @GetMapping("/teachers")
    @PreAuthorize("hasAnyRole('ADMIN', 'EMPLOYEE')")
    public ResponseEntity<List<TeacherDto>> getAllTeachers(){
        return ResponseEntity.ok(teacherService.findTeachers());
    }

    @PostMapping("/save/teacher")
    public ResponseEntity<TeacherDto> saveTeacher(@RequestBody @Valid TeacherDto teacherDto) throws URISyntaxException {
        return ResponseEntity.created(new URI("/save/teacher")).body(teacherService.addTeacher(teacherDto));
    }

    @PutMapping("/edit/teacher")
    public ResponseEntity<TeacherDto> editTeacher(@RequestBody @Valid TeacherDto teacherDto){
        return ResponseEntity.ok(teacherService.editTeacher(teacherDto));
    }

    @DeleteMapping("/delete/teacher")
    public ResponseEntity<Void> removeTeacher(@RequestBody TeacherDto teacherDto){
        teacherService.removeTeacher(teacherDto.getId());
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/teacher")
    public ResponseEntity<TeacherDto> getTeacherByUserName(@RequestParam String userName) throws SystemException {
        return ResponseEntity.ok(teacherService.getByUserName(userName));
    }

    @GetMapping("/teacher/{id}")
    public ResponseEntity<TeacherDto> getTeacherById(@PathVariable Long id) throws SystemException {
        return ResponseEntity.ok(teacherService.getById(id));
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

package com.spring.boot908.controller;

import com.spring.boot908.dto.TeacherDto;
import com.spring.boot908.service.TeacherService;
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
    @PreAuthorize("hasAnyRole('ADMIN')")
    public ResponseEntity<List<TeacherDto>> getTeacher(){
        return ResponseEntity.ok(teacherService.getAllTeachers());
    }

    // URI   URL
    // URL http://localhost:9090/teacher/save
    // /teacher/save
    @PostMapping("/teacher/save")
    public ResponseEntity<TeacherDto> saveTeacher(@RequestBody @Valid TeacherDto teacherDto) throws URISyntaxException, SystemException {
        return ResponseEntity.created(new URI("/teacher/save")).body(teacherService.saveTeacher(teacherDto));
    }

    @PutMapping("/teacher/update")
    public ResponseEntity<TeacherDto> updateTeacher(@RequestBody @Valid  TeacherDto teacherDto){
        return ResponseEntity.ok(teacherService.updateTeacher(teacherDto));
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
    public ResponseEntity<Void> deleteTeacher(@PathVariable("teacherId") Long id){
        teacherService.deleteTeacher(id);
        return ResponseEntity.noContent().build();
    }

    // api not found
    @GetMapping("/teacher/{teacherId}")
    public ResponseEntity<TeacherDto> getTeacher(@PathVariable("teacherId") Long id){
        return ResponseEntity.ok(teacherService.getTeacherById(id));
    }

    @GetMapping("/teacher/username")
    public ResponseEntity<TeacherDto> getTeacher(@RequestParam String userName){
        return ResponseEntity.ok(teacherService.getTeacherByUserName(userName));
    }
}

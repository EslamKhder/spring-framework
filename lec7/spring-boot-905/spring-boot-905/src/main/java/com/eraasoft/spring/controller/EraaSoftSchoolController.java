package com.eraasoft.spring.controller;

import com.eraasoft.spring.model.EraaSoftSchool;
import com.eraasoft.spring.service.EraaSoftSchoolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EraaSoftSchoolController {

    private EraaSoftSchoolService eraaSoftSchoolService;

    @Autowired
    public EraaSoftSchoolController(EraaSoftSchoolService eraaSoftSchoolService) {
        this.eraaSoftSchoolService = eraaSoftSchoolService;
    }

    @PostMapping("/save-student")
    EraaSoftSchool addStudent(@RequestBody EraaSoftSchool eraaSoftSchool) {
        return eraaSoftSchoolService.save(eraaSoftSchool);
    }

    @PutMapping("/update-student")
    EraaSoftSchool updateStudent(@RequestBody EraaSoftSchool eraaSoftSchool) {
        return eraaSoftSchoolService.update(eraaSoftSchool);
    }

    // param
    // path
    // http://localhost:9090/delete-student?id=5
    // http://localhost:9090/delete-student/5
//    @DeleteMapping("/delete/student/{id}")
    @DeleteMapping("/delete/student")
    boolean deleteStudent(@RequestParam("studentId") Long id) {
//    boolean deleteStudent(@PathVariable Long id) {
        return eraaSoftSchoolService.delete(id);
    }

    @GetMapping("/students")
    List<EraaSoftSchool> getAllStudent() {
        return eraaSoftSchoolService.getAll();
    }

//    @GetMapping("/student/{id}")
    @GetMapping("/student")
    EraaSoftSchool getStudentById(@RequestParam Long id) {
        return eraaSoftSchoolService.getById(id);
    }

    @GetMapping("/student/user-name/{userName}")
    EraaSoftSchool getStudentById(@PathVariable String userName) {
        return eraaSoftSchoolService.getByUserName(userName);
    }
}

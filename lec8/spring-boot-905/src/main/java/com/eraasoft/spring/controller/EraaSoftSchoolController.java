package com.eraasoft.spring.controller;

import com.eraasoft.spring.model.EraaSoftSchool;
import com.eraasoft.spring.service.EraaSoftSchoolService;
import jakarta.transaction.SystemException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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
    ResponseEntity<EraaSoftSchool> addStudent(@RequestBody EraaSoftSchool eraaSoftSchool) throws SystemException {
        return ResponseEntity.ok(eraaSoftSchoolService.save(eraaSoftSchool));
    }

    @PutMapping("/update-student")
    ResponseEntity<EraaSoftSchool> updateStudent(@RequestBody EraaSoftSchool eraaSoftSchool) {
        return ResponseEntity.ok(eraaSoftSchoolService.update(eraaSoftSchool));
    }

    @DeleteMapping("/delete/student")
    ResponseEntity<Void> deleteStudent(@RequestParam("studentId") Long id) {
        return eraaSoftSchoolService.delete(id) ?
                ResponseEntity.noContent().build() :
                    ResponseEntity.notFound().build();
    }

    @GetMapping("/students")
    ResponseEntity<List<EraaSoftSchool>> getAllStudent() {
        return ResponseEntity.ok(eraaSoftSchoolService.getAll());
    }

    @GetMapping("/student")
    ResponseEntity<EraaSoftSchool> getStudentById(@RequestParam Long id) {
        return ResponseEntity.ok(eraaSoftSchoolService.getById(id));
    }

    @GetMapping("/student/user-name/{userName}")
    ResponseEntity<EraaSoftSchool> getStudentById(@PathVariable String userName) {
        return ResponseEntity.ok(eraaSoftSchoolService.getByUserName(userName));
    }
}

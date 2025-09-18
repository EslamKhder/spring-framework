package com.spring.boot.service.impl;

import com.spring.boot.model.Student;
import com.spring.boot.repo.StudentRepo;
import com.spring.boot.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentRepo studentRepo;

    @Override
    public Student saveStudent(Student student) {
        return studentRepo.save(student);
    }

    @Override
    public Student updateStudent(Student student) {
        return studentRepo.save(student);
    }

    @Override
    public void removeStudentById(Long id) {
        studentRepo.deleteById(id);
    }

    @Override
    public Student getStudentById(Long id) {
        return studentRepo.findById(id).get();
    }

    @Override
    public List<Student> getStudents() {
        return studentRepo.findAll();
    }
}

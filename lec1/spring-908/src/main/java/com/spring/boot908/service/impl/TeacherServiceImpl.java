package com.spring.boot908.service.impl;

import com.spring.boot908.model.Teacher;
import com.spring.boot908.repo.TeacherRepo;
import com.spring.boot908.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TeacherServiceImpl implements TeacherService {

    private TeacherRepo teacherRepo;

    @Autowired
    public TeacherServiceImpl(TeacherRepo teacherRepo) {
        this.teacherRepo = teacherRepo;
    }

    @Override
    public List<Teacher> getAllTeachers() {
        return teacherRepo.findAll();
    }

    @Override
    public Teacher saveTeacher(Teacher teacher) {
        return teacherRepo.save(teacher);
    }

    @Override
    public Teacher updateTeacher(Teacher teacher) {
        return teacherRepo.save(teacher);
    }

    @Override
    public void deleteTeacher(Long id) {
        teacherRepo.deleteById(id);
    }

    @Override
    public Teacher getTeacherById(Long id) {
        Optional<Teacher> teacher =  teacherRepo.findById(id);
        return teacher.get();
    }
}

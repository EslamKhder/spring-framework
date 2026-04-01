package com.spring.demo.service.impl;

import com.spring.demo.model.Teacher;
import com.spring.demo.repo.TeacherRepo;
import com.spring.demo.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeacherServiceImpl implements TeacherService {

    private TeacherRepo teacherRepo;

    @Autowired
    public TeacherServiceImpl(TeacherRepo teacherRepo) {
        this.teacherRepo = teacherRepo;
    }

    @Override
    public Teacher createTeacher(Teacher teacher) {
        return teacherRepo.save(teacher); //teacher id = null
    }

    @Override
    public Teacher updateTeacher(Teacher teacher) {
        return teacherRepo.save(teacher);//teacher id = 1
    }

    @Override
    public Teacher getTeacherById(Long id) {
        return teacherRepo.getById(id);
    }

    @Override
    public List<Teacher> getTeachers() {
        return teacherRepo.findAll();
    }

    @Override
    public void removeTeacherById(Long id) {
        teacherRepo.deleteById(id);
    }
}

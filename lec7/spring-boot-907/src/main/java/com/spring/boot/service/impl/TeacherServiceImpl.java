package com.spring.boot.service.impl;

import com.spring.boot.model.Teacher;
import com.spring.boot.repo.TeacherRepo;
import com.spring.boot.service.TeacherService;
import jakarta.transaction.SystemException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class TeacherServiceImpl implements TeacherService {

    private TeacherRepo teacherRepo;

    @Autowired
    public TeacherServiceImpl(TeacherRepo teacherRepo) {
        this.teacherRepo = teacherRepo;
    }

    @Override
    public List<Teacher> findTeachers() {
        return teacherRepo.findAll();
    }

    @Override
    public Teacher addTeacher(Teacher teacher) {
        if (Objects.nonNull(teacher.getId())) {
            throw new IllegalArgumentException("New teacher must not have an ID before saving.");
        }

        if (Objects.isNull(teacher.getName())) {
            throw new IllegalArgumentException("Name must be not null.");
        }

        if (Objects.isNull(teacher.getUserName())) {
            throw new IllegalArgumentException("UserName be not null.");
        }

        if (Objects.isNull(teacher.getPassword())) {
            throw new IllegalArgumentException("Password be not null.");
        }

//        teacherRepo.find
//        if () {
//
//        }
        return teacherRepo.save(teacher);
    }

    @Override
    public Teacher editTeacher(Teacher teacher) {
        if (Objects.isNull(teacher.getId())) {
            throw new IllegalArgumentException("updated teacher must have an ID before update.");
        }
        return teacherRepo.save(teacher);
    }

    @Override
    public void removeTeacher(Long id) {
        if (Objects.isNull(id)) {
            throw new IllegalArgumentException("id must be not null.");
        }

        Teacher teacher = teacherRepo.getById(id); // id

        if (Objects.isNull(teacher.getId())) {
            throw new IllegalArgumentException("Teacher not exist with id " + id);
        }

        teacherRepo.deleteById(id);
    }
}

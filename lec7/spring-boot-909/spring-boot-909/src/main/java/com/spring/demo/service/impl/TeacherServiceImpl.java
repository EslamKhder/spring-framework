package com.spring.demo.service.impl;

import com.spring.demo.model.Teacher;
import com.spring.demo.repo.TeacherRepo;
import com.spring.demo.service.TeacherService;
import jakarta.transaction.SystemException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

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
    public Teacher createTeacher(Teacher teacher) throws SystemException {
        if (Objects.nonNull(teacher.getId())) {
            throw new SystemException("id must be null");
        }
        if (Objects.isNull(teacher.getUserName())) {
            throw new SystemException("UserName must be not null");
        }

        if (Objects.isNull(teacher.getPassword())) {
            throw new SystemException("Password must be not null");
        }

        return teacherRepo.save(teacher); //teacher id = null
    }

    @Override
    public Teacher updateTeacher(Teacher teacher) throws SystemException {
        if (Objects.isNull(teacher.getId())) {
            throw new SystemException("id must be not null");
        }
        if (Objects.isNull(teacher.getUserName())) {
            throw new SystemException("UserName must be not null");
        }

        if (Objects.isNull(teacher.getPassword())) {
            throw new SystemException("Password must be not null");
        }

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

    @Override
    public Teacher getTeacherByUserName(String userName) {
        return teacherRepo.extractByUserName(userName);
    }
    @Override
    public List<Teacher> findByFirstNameStartingWithOrderByFirstNameDesc(String firstName) {
        return teacherRepo.findByFirstNameStartingWithOrderByFirstNameAsc(firstName);
    }
}

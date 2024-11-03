package com.spring.service.impl;


import com.spring.dao.TeacherDao;
import com.spring.dto.TeacherDto;
import com.spring.mapper.TeacherMapper;
import com.spring.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeacherServiceImpl implements TeacherService {


    @Autowired
    private TeacherDao teacherDao;

    @Override
    public List<TeacherDto> getAllTeacher() {
        return TeacherMapper.teacherMapper.toDtoList(teacherDao.findAll());
    }
}

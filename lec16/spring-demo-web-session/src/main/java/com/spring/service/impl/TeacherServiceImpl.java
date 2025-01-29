package com.spring.service.impl;


import com.spring.dao.TeacherDao;
import com.spring.dto.StudentDto;
import com.spring.dto.TeacherDto;
import com.spring.mapper.StudentMapper;
import com.spring.mapper.TeacherMapper;
import com.spring.model.Student;
import com.spring.model.Teacher;
import com.spring.service.StudentService;
import com.spring.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeacherServiceImpl implements TeacherService {


    @Autowired
    private TeacherDao teacherDao;

    @Autowired
    private StudentService studentService;

    @Override
    public List<TeacherDto> getAllTeacher() {
        return TeacherMapper.teacherMapper.toDtoList(teacherDao.findAll());
    }

    @Override
    public List<TeacherDto> getTeacherWithStudents() {
        List<TeacherDto> teachers = TeacherMapper.teacherMapper.toDtoList(teacherDao.findAll());
        for(TeacherDto teacherDto: teachers){
            List<StudentDto> studentDtos = studentService.getStudentsByTeacherId(teacherDto.getId());
            teacherDto.setStudents(studentDtos);
        }

        return teachers;
    }

    @Override
    public TeacherDto getTeacherByIdWithStudent(Long id) {
        TeacherDto teacher = TeacherMapper.teacherMapper.toDto(teacherDao.findById(id).get());
        List<StudentDto> studentDtos = studentService.getStudentsByTeacherId(teacher.getId());
        teacher.setStudents(studentDtos);

        return teacher;
    }

    @Override
    public TeacherDto getTeacherById(Long id) {
        return TeacherMapper.teacherMapper.toDto(teacherDao.findById(id).get());
    }

    @Override
    public void saveListOfTeacher(List<TeacherDto> teachers) {
        teacherDao.saveAll(TeacherMapper.teacherMapper.toEntityList(teachers));
    }

    @Override
    public void saveTeacherWithListOfStudents(TeacherDto teacher) {
//        Teacher teacherData = TeacherMapper.teacherMapper.toEntity(teacher);
//
//        Teacher teacherSaved = teacherDao.save(teacherData);
//
//        for (StudentDto student: teacher.getStudents()) {
//            student.setTeacher(TeacherMapper.teacherMapper.toDto(teacherSaved));
//        }
//        studentService.addListOfStudent(teacher.getStudents());

        //studentService.addListOfStudent(teacher.getStudents());


        Teacher teacherData = TeacherMapper.teacherMapper.toEntity(teacher);


        for (Student student: teacherData.getStudents()) {
            student.setTeacher(teacherData);
        }

        teacherDao.save(teacherData);
    }
}

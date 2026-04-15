package com.spring.demo.service.impl;

import com.spring.demo.dto.TeacherDto;
import com.spring.demo.model.Teacher;
import com.spring.demo.repo.TeacherRepo;
import com.spring.demo.service.TeacherService;
import jakarta.transaction.SystemException;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class TeacherServiceImpl implements TeacherService {

    private TeacherRepo teacherRepo;

    private ModelMapper modelmapper;


    @Autowired
    public TeacherServiceImpl(TeacherRepo teacherRepo, ModelMapper modelmapper) {
        this.teacherRepo = teacherRepo;
        this.modelmapper = modelmapper;
    }

    @Override
    public TeacherDto createTeacher(TeacherDto teacherDto) throws SystemException {
        Teacher teacher = modelmapper.map(teacherDto, Teacher.class);
        teacher = teacherRepo.save(teacher);
        return modelmapper.map(teacher, TeacherDto.class);
    }

    @Override
    public TeacherDto updateTeacher(TeacherDto teacherDto) throws SystemException {

        Teacher teacher = modelmapper.map(teacherDto, Teacher.class);

        teacherRepo.save(teacher);//teacher id = 1

        return teacherDto;
    }

    @Override
    public TeacherDto getTeacherById(Long id) {
        Teacher teacher =  teacherRepo.getById(id);
        TeacherDto teacherDto = modelmapper.map(teacher, TeacherDto.class);
        teacherDto.setCommissionSalary(teacher.getCommission() * Float.parseFloat(teacher.getSalary()));
        return teacherDto;
    }

    @Override
    public List<TeacherDto> getTeachers() {
        List<Teacher> teachers = teacherRepo.findAll();

        return teachers.stream().map(teacher -> {
            TeacherDto teacherDto = modelmapper.map(teacher, TeacherDto.class);
            teacherDto.setCommissionSalary(teacher.getCommission() * Float.parseFloat(teacher.getSalary()));
            teacherDto.setFullName(teacher.getFirstName() + " " + teacher.getLastName());
            return teacherDto;
        }).collect(Collectors.toList());
    }

    @Override
    public void removeTeacherById(Long id) {
        teacherRepo.deleteById(id);
    }

    @Override
    public TeacherDto getTeacherByUserName(String userName) {
        Teacher teacher =  teacherRepo.extractByUserName(userName);

        TeacherDto teacherDto = modelmapper.map(teacher, TeacherDto.class);
        teacherDto.setCommissionSalary(teacher.getCommission() * Float.parseFloat(teacher.getSalary()));

        return teacherDto;
    }
    @Override
    public List<TeacherDto> findByFirstNameStartingWithOrderByFirstNameDesc(String firstName) {
        List<Teacher> teachers = teacherRepo.findByFirstNameStartingWithOrderByFirstNameAsc(firstName);
        return teachers.stream().map(teacher -> {
            TeacherDto teacherDto = modelmapper.map(teacher, TeacherDto.class);
            teacherDto.setFullName(teacher.getFirstName() + " " + teacher.getLastName());
            teacherDto.setCommissionSalary(teacher.getCommission() * Float.parseFloat(teacher.getSalary()));
            return teacherDto;
        }).collect(Collectors.toList());
    }
}

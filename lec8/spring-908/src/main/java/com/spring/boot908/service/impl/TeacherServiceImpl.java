package com.spring.boot908.service.impl;

import com.spring.boot908.dto.TeacherDto;
import com.spring.boot908.model.Teacher;
import com.spring.boot908.repo.TeacherRepo;
import com.spring.boot908.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class TeacherServiceImpl implements TeacherService {

    private TeacherRepo teacherRepo;

    @Autowired
    public TeacherServiceImpl(TeacherRepo teacherRepo) {
        this.teacherRepo = teacherRepo;
    }

    @Override
    public List<TeacherDto> getAllTeachers() {
        List<Teacher> teachers = teacherRepo.findAll();



        List<TeacherDto> teacherDtos = teachers.stream().map(teacher ->
                new TeacherDto(teacher.getId(), teacher.getUserName(), teacher.getPassword()))
                .collect(Collectors.toList());

        teacherDtos.stream().forEach(teacherDto -> {
            String resCon = teacherDto.getUserName() + " - " + teacherDto.getPassword();
            teacherDto.setConCatUserNameAndPassword(resCon);
        });

        return teacherDtos;
    }

    @Override
    public TeacherDto saveTeacher(TeacherDto teacherDto) {

        if (Objects.nonNull(teacherDto.getId())) {
            throw new RuntimeException("id must be null");
        }

        if (Objects.isNull(teacherDto.getUserName())){
            throw new RuntimeException("user name must be not null");
        }

        if (Objects.isNull(teacherDto.getPassword())){
            throw new RuntimeException("Password must be not null");
        }

        Optional<Teacher> teacherOptional = teacherRepo.extractByUserName(teacherDto.getUserName());
        if(teacherOptional.isPresent()){
            throw new RuntimeException("exist Teacher with same userName: " + teacherDto.getUserName());
        }

        Teacher teacher = teacherRepo.save(new Teacher(teacherDto.getUserName(), teacherDto.getPassword()));

        teacherDto.setId(teacher.getId());
        return teacherDto;
    }

    @Override
    public TeacherDto updateTeacher(TeacherDto teacherDto) {
        if (Objects.isNull(teacherDto.getId())) {
            throw new RuntimeException("id must be not null");
        }

        teacherRepo.save(new Teacher(teacherDto.getId(), teacherDto.getUserName(), teacherDto.getPassword()));

        return teacherDto;
    }

    @Override
    public void deleteTeacher(Long id) {
        Optional<Teacher> teacher =  teacherRepo.findById(id);
        if(teacher.isEmpty()){
            throw new RuntimeException("can't delete id not exist " + id);
        }
        teacherRepo.deleteById(id);
    }

    @Override
    public TeacherDto getTeacherById(Long id) {
        Optional<Teacher> teacherOptional =  teacherRepo.findById(id);
        if(teacherOptional.isEmpty()){
            throw new RuntimeException("Teacher not exist with id: " + id);
        }
        Teacher teacher = teacherOptional.get();
        return new TeacherDto(teacher.getId(), teacher.getUserName(), teacher.getPassword());
    }

    @Override
    public TeacherDto getTeacherByUserName(String userName) {
        Optional<Teacher> teacherOptional = teacherRepo.extractByUserName(userName);
        if(teacherOptional.isEmpty()){
            throw new RuntimeException("Teacher not exist with userName: " + userName);
        }
        Teacher teacher = teacherOptional.get();
        return new TeacherDto(teacher.getId(), teacher.getUserName(), teacher.getPassword());
    }
}

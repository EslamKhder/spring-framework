package com.spring.boot.service.impl;

import com.spring.boot.dto.TeacherDto;
import com.spring.boot.mapper.TeacherMapper;
import com.spring.boot.model.Teacher;
import com.spring.boot.repo.TeacherRepo;
import com.spring.boot.service.TeacherService;
import jakarta.transaction.SystemException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class TeacherServiceImpl implements TeacherService {

    private TeacherRepo teacherRepo;

    private TeacherMapper teacherMapper;

    @Autowired
    public TeacherServiceImpl(TeacherRepo teacherRepo, TeacherMapper teacherMapper) {
        this.teacherRepo = teacherRepo;
        this.teacherMapper = teacherMapper;
    }

    @Override
    public List<TeacherDto> findTeachers() {
        List<Teacher> teachers = teacherRepo.findAll();
        return teachers.stream().map(teacher -> teacherMapper.toDto(teacher)).collect(Collectors.toList());
    }

    @Override
    public TeacherDto addTeacher(TeacherDto teacherDto) {
        if (Objects.nonNull(teacherDto.getId())) {
            throw new IllegalArgumentException("New teacher must not have an ID before saving.");
        }

        if (teacherRepo.findByUserName(teacherDto.getUserName()).isPresent()) {
            throw new IllegalArgumentException("teacher already exist with same username " + teacherDto.getUserName());
        }
        Teacher teacher = teacherMapper.toEntity(teacherDto);
        teacher = teacherRepo.save(teacher);

        teacherDto.setId(teacher.getId());
        return teacherDto;
    }

    @Override
    public TeacherDto editTeacher(TeacherDto teacherDto) {
        if (Objects.isNull(teacherDto.getId())) {
            throw new IllegalArgumentException("updated teacher must have an ID before update.");
        }

        Teacher teacher = teacherMapper.toEntity(teacherDto);
        teacherRepo.save(teacher);

        return teacherDto;
    }

    @Override
    public void removeTeacher(Long id) {
        if (Objects.isNull(id)) {
            throw new IllegalArgumentException("id must be not null.");
        }

        Optional<Teacher> teacher = teacherRepo.findById(id); // id

        if (teacher.isEmpty()) {
            throw new IllegalArgumentException("Teacher not exist with id " + id);
        }

        teacherRepo.deleteById(id);
    }

    @Override
    public TeacherDto getByUserName(String userName) throws SystemException {
        Optional<Teacher> teacherOptional =teacherRepo.findByUserName(userName);

        if (teacherOptional.isEmpty()) {
            throw new SystemException("teacher not found with username " + userName);
        }

        Teacher teacher = teacherOptional.get();

        return teacherMapper.toDto(teacher);
    }

    @Override
    public TeacherDto getById(Long id) throws SystemException {

        Optional<Teacher> teacherOptional = teacherRepo.findById(id);

        if (teacherOptional.isEmpty()) {
            throw new SystemException("teacher not found with id " + id);
        }

        Teacher teacher = teacherOptional.get();

        return teacherMapper.toDto(teacher);
    }
}

package com.spring.demo.service.impl;

import com.spring.demo.dto.TeacherDto;
import com.spring.demo.mapper.TeacherMapper;
import com.spring.demo.model.Teacher;
import com.spring.demo.repo.TeacherRepo;
import com.spring.demo.service.TeacherService;
import jakarta.transaction.SystemException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class TeacherServiceImpl implements TeacherService {

    private TeacherRepo teacherRepo;

//    private ModelMapper modelmapper;

    private TeacherMapper teacherMapper;

    @Autowired
    public TeacherServiceImpl(TeacherRepo teacherRepo, TeacherMapper teacherMapper) {
        this.teacherRepo = teacherRepo;
        this.teacherMapper = teacherMapper;
    }

    @Override
    public TeacherDto createTeacher(TeacherDto teacherDto) throws SystemException {

        Optional<Teacher> teacherOptional = teacherRepo.findByUserName(teacherDto.getUserName());

        if (teacherOptional.isPresent()) {
            throw new SystemException("error.username.exist");
        }

        Teacher teacher = teacherMapper.toEntity(teacherDto);

        teacher = teacherRepo.save(teacher);
        return teacherMapper.toDto(teacher);
    }

    @Override
    public TeacherDto updateTeacher(TeacherDto teacherDto) throws SystemException {

        Teacher teacher = teacherMapper.toEntity(teacherDto);

        teacherRepo.save(teacher);//teacher id = 1

        return teacherDto;
    }

    @Override
    public TeacherDto getTeacherById(Long id) {
        Optional<Teacher> teacher =  teacherRepo.findById(id);
        TeacherDto teacherDto = teacherMapper.toDto(teacher.get());
        teacherDto.setCommissionSalary(teacher.get().getCommission() * Float.parseFloat(teacher.get().getSalary()));
        return teacherDto;
    }

    @Override
    public List<TeacherDto> getTeachers() {
        List<Teacher> teachers = teacherRepo.findAll();

        return teacherMapper.toDtoList(teachers);
//        return teachers.stream().map(teacher -> {
//            TeacherDto teacherDto = teacherMapper.toDto(teacher);
//            teacherDto.setCommissionSalary(teacher.getCommission() * Float.parseFloat(teacher.getSalary()));
//            teacherDto.setFullName(teacher.getFirstName() + " " + teacher.getLastName());
//            return teacherDto;
//        }).collect(Collectors.toList());
    }

    @Override
    public void removeTeacherById(Long id) {
        teacherRepo.deleteById(id);
    }

    @Override
    public TeacherDto getTeacherByUserName(String userName) throws SystemException {
        Optional<Teacher> teacherOptional =  teacherRepo.extractByUserName(userName);

        if (!teacherOptional.isPresent()){
            throw new SystemException("user name not exit");
        }

        TeacherDto teacherDto = teacherMapper.toDto(teacherOptional.get());
        teacherDto.setCommissionSalary(teacherOptional.get().getCommission() * Float.parseFloat(teacherOptional.get().getSalary()));

        return teacherDto;
    }
    @Override
    public List<TeacherDto> findByFirstNameStartingWithOrderByFirstNameDesc(String firstName) {
        List<Teacher> teachers = teacherRepo.findByFirstNameStartingWithOrderByFirstNameAsc(firstName);
        return teacherMapper.toDtoList(teachers);
//        return teachers.stream().map(teacher -> {
//            TeacherDto teacherDto = teacherMapper.toDto(teacher);
//            teacherDto.setFullName(teacher.getFirstName() + " " + teacher.getLastName());
//            teacherDto.setCommissionSalary(teacher.getCommission() * Float.parseFloat(teacher.getSalary()));
//            return teacherDto;
//        }).collect(Collectors.toList());
    }
}

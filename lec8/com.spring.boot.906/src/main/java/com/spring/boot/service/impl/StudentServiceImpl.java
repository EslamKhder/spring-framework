package com.spring.boot.service.impl;

import com.spring.boot.StudentDto.StudentDto;
import com.spring.boot.model.Student;
import com.spring.boot.repo.StudentRepo;
import com.spring.boot.service.StudentService;
import jakarta.transaction.SystemException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentRepo studentRepo;

    @Override
    public StudentDto saveStudent(StudentDto studentDto)  throws SystemException {
        if (Objects.nonNull(studentDto.getId())) {
            throw new SystemException("id must be null");
        }

        if (Objects.isNull(studentDto.getName())) {
            throw new SystemException("name must be not null");
        }

        if (Objects.isNull(studentDto.getPhoneNumber())) {
            throw new SystemException("PhoneNumber must be no null");
        }
        Student student =
                new Student(studentDto.getName(), "", "", studentDto.getPhoneNumber());
        student = studentRepo.save(student);
        studentDto.setId(student.getId());
        return studentDto;
    }

    @Override
    public StudentDto updateStudent(StudentDto studentDto)  throws SystemException {
        if (Objects.isNull(studentDto.getId())) {
            throw new SystemException("id must be not null");
        }

        Student student =
                new Student(studentDto.getId(), studentDto.getName(), "", "", studentDto.getPhoneNumber());

        student = studentRepo.save(student); // id= 5

        studentDto.setId(student.getId());
        return studentDto;
    }

    @Override
    public void removeStudentById(Long id) throws SystemException {
        Optional<Student> studentDto = studentRepo.findById(id);

        if (studentDto.isEmpty()) {
            throw new SystemException("no StudentDto found with id " + id);
        }

        studentRepo.deleteById(id);
    }

    @Override
    public StudentDto getStudentById(Long id) throws SystemException {
        Optional<Student> studentOptional = studentRepo.findById(id);

        if (studentOptional.isEmpty()) {
            throw new SystemException("no StudentDto found with id " + id);
        }

        Student student = studentOptional.get();

        return new StudentDto(student.getId(), student.getName(), student.getPhoneNumber());

    }

    @Override
    public List<StudentDto> getStudents() {
        List<Student> students = studentRepo.findAll();

        return students.stream().map(student ->
                new StudentDto(student.getId(), student.getName(), student.getPhoneNumber()
        )).collect(Collectors.toList());

    }

    @Override
    public List<StudentDto> getStudentsByName(String name) throws SystemException {
        List<Student> students = studentRepo.extractByName(name);

        if (students.isEmpty()) {
            throw new SystemException("no StudentDto found with name " + name);
        }

        return students.stream().map(student ->
                new StudentDto(student.getId(), student.getName(), student.getPhoneNumber()
                )).collect(Collectors.toList());
    }
}

package com.spring.boot.service.impl;

import com.spring.boot.dto.StudentDto;
import com.spring.boot.mapper.StudentMapper;
import com.spring.boot.model.Student;
import com.spring.boot.repo.StudentRepo;
import com.spring.boot.service.StudentService;
import jakarta.transaction.SystemException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentRepo studentRepo;

//    @Autowired
//    private ModelMapper modelMapper;

    @Autowired
    private StudentMapper studentMapper;

    @Override
    public StudentDto saveStudent(StudentDto studentDto)  throws SystemException {
        if (Objects.nonNull(studentDto.getId())) {
            throw new SystemException("student.id.not.required");
        }

        Student student = studentMapper.toEntity(studentDto);

        student = studentRepo.save(student);
        studentDto.setId(student.getId());
        return studentDto;
    }

    @Override
    public StudentDto updateStudent(StudentDto studentDto)  throws SystemException {
        if (Objects.isNull(studentDto.getId())) {
            throw new SystemException("id must be not null");
        }

        Student student = studentMapper.toEntity(studentDto);

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

        return studentMapper.toDto(student);
    }

    @Override
    public List<StudentDto> getStudents() {
        List<Student> students = studentRepo.findAll();

        return studentMapper.toListDto(students);
    }

    @Override
    public List<StudentDto> getStudentsByName(String name) throws SystemException {
        List<Student> students = studentRepo.extractByName(name);

        if (students.isEmpty()) {
            throw new SystemException("no StudentDto found with name " + name);
        }

        return studentMapper.toListDto(students);
    }

    @Override
    public StudentDto getStudentsByUserName(String useName) {
        Optional<Student> student = studentRepo.findByUserName(useName);

        if (student.isEmpty()) {
            throw new RuntimeException("no StudentDto found with name " + useName);
        }

        return studentMapper.toDto(student.get());
    }
}

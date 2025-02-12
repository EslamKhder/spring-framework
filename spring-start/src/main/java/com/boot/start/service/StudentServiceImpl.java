package com.boot.start.service;

import com.boot.start.dto.StudentDto;
import com.boot.start.model.Student;
import com.boot.start.repo.StudentRepo;
import com.boot.start.service.mapper.StudentMapper;
import jakarta.transaction.SystemException;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentRepo studentRepo;
    @Override
    public Student saveStudent(StudentDto studentDto) throws SystemException {

        if (Objects.nonNull(studentDto.getId())) {
            throw new RuntimeException("invalid.id");
        }

        Student student = StudentMapper.STUDENT_MAPPER.toEntity(studentDto);
        return studentRepo.save(student);
    }

    @Override
    public List<StudentDto> saveListOfStudent(List<StudentDto> studentDtos) throws SystemException {

        for(StudentDto studentDto: studentDtos){
            if (Objects.nonNull(studentDto.getId())) {
                throw new RuntimeException("invalid.id");
            }
        }
        List<Student> students = StudentMapper.STUDENT_MAPPER.toEntityList(studentDtos);

        return StudentMapper.STUDENT_MAPPER.toDtoList(studentRepo.saveAll(students));
    }

    @Override
    public Student updateStudent(Student student) throws SystemException {

        if (Objects.isNull(student.getId())) {
            throw new SystemException("id must be not null");
        }

        return studentRepo.save(student);
    }

    @Override
    public void deleteStudent(Integer studentId) throws SystemException {
        if (Objects.isNull(studentId)) {
            throw new SystemException("id must be not null");
        }

        studentRepo.deleteById(studentId);
    }

    @Override
    public List<Student> getStudents() {
        return studentRepo.findAll();
    }

    @Override
    public List<Student> getStudentByName(String name) {
        return studentRepo.findByName(name);
    }

    @Override
    public List<Student> getStudentByAddress(String address) {
        return studentRepo.extractStudentsByAddressContaining(address);
    }
}

package com.spring.wev.service;

import com.spring.wev.dao.StudentDao;
import com.spring.wev.dto.StudentDto;
import com.spring.wev.model.Student;
import jakarta.transaction.SystemException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class StudentServiceImpl implements StudentService{

    @Autowired
    private StudentDao studentDao;

    @Override
    public void addStudent(StudentDto student) throws SystemException {
        if (student.getId() != null) {
            throw new SystemException("id must be null");
        }
        if (student.getName().length() < 5) {
            throw new SystemException("name must be greater than 5");
        }

        Student studentEntity = new Student();
        studentEntity.setName(student.getName());
        studentEntity.setAge(student.getAge());
        studentEntity.setPassword(student.getPassword());
        studentEntity.setGPA(student.getGPA());
        studentDao.save(studentEntity);
    }

    @Override
    public Student getStudentById(Long id) {
        return studentDao.findById(id).get();
    }

    @Override
    public void removeStudentById(Long id) {
        studentDao.deleteById(id);
    }

    @Override
    public void updateStudent(Student student) {
        studentDao.save(student);
    }

    @Override
    public List<StudentDto> getAllStudent() {
        List<StudentDto> studentDtos = new ArrayList<>();
        List<Student> students = studentDao.findAll();
        Double avg = studentDao.getAvgOfAge();

        for (Student student: students) {
            StudentDto studentDto = new StudentDto();
            studentDto.setId(student.getId());
            studentDto.setName(student.getName());
            studentDto.setAge(student.getAge());
            studentDto.setGPA(student.getGPA());
            studentDto.setAvgOfAge(avg);

            studentDtos.add(studentDto);
        }

        return studentDtos;
    }

    @Override
    public List<Student> getStudentLikeLetter(String letters) {
        return studentDao.findByNameContains(letters);
    }

    @Override
    public List<Student> getStudentByName(String name) {
        return studentDao.findByName(name);
    }

    @Override
    public List<Student> getStudentByAge(int age) {
        return studentDao.fetchByAgeV2(age);
    }


}

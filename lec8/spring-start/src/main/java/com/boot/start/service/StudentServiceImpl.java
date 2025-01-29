package com.boot.start.service;

import com.boot.start.model.Student;
import com.boot.start.repo.StudentRepo;
import jakarta.transaction.SystemException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentRepo studentRepo;

    @Override
    public Student saveStudent(Student student) throws SystemException {

        if (Objects.nonNull(student.getId())) {
            throw new SystemException("id must be null");
        }

        return studentRepo.save(student);
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
}

package com.spring.service.impl;

import com.spring.dao.StudentDao;
import com.spring.dto.StudentDto;
import com.spring.dto.TeacherDto;
import com.spring.mapper.StudentMapper;
import com.spring.model.Student;
import com.spring.service.StudentService;
import com.spring.service.TeacherService;
import jakarta.transaction.SystemException;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentDao studentDao;

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    @Lazy
    private TeacherService teacherService;
    @Override
    public void addStudent(StudentDto studentDto) throws SystemException {

        if (studentDto.getId() != null) {
            throw new SystemException("error.id");
        }
//        if (studentDto.getMyFirst() == null) {
//            throw new SystemException("error.name");
//        }
//        if (studentDto.getMyFirst().length() < 5) {
//            throw new SystemException("name must be greater than 5");
//        }

        Student stu = StudentMapper.studentMapper.toEntity(studentDto);
       // Student stu = modelMapper.map(studentDto, Student.class);

        /*
        Student studentEntity = new Student();
        studentEntity.setName(student.getName());
        studentEntity.setAge(student.getAge());
        studentEntity.setPassword(student.getPassword());
        studentEntity.setGPA(student.getGPA());
        */
        studentDao.save(stu);
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
    public List<Student> getAllStudent() {
        //List<StudentDto> studentDtos = new ArrayList<>();
        List<Student> students = studentDao.findAll();
//        Double avg = studentDao.getAvgOfAge();

        return students;
//        for (Student student: students) {
//            StudentDto studentDto = StudentMapper.studentMapper.convertFromStudentToStudentDto(student);
////            StudentDto studentDto = modelMapper.map(student, StudentDto.class);
//            /*StudentDto studentDto = new StudentDto();
//            studentDto.setId(student.getId());
//            studentDto.setMyFirst(student.getName());
//            studentDto.setAge(student.getAge());
//            studentDto.setGPA(student.getGPA());
//            studentDto.setAvgOfAge(avg);
//            studentDto.setPassword(student.getPassword());*/
//
//            studentDtos.add(studentDto);
//        }

        //return studentDtos;
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
    public List<StudentDto> getByListOfId(List<Long> ids) {
        return StudentMapper.studentMapper.toDtoList(studentDao.findAllById(ids));

    }

    @Override
    public void addListOfStudent(List<StudentDto> studentDtos) {
        studentDao.saveAll(StudentMapper.studentMapper.toEntityList(studentDtos));
    }

    @Override
    public List<StudentDto> getStudentsByTeacherId(Long id) {
        return StudentMapper.studentMapper.toDtoList(studentDao.findByTeacherId(id));
    }

    @Override
    public List<StudentDto> getStudentListWithTeacher() {
        List<Student> students = studentDao.findAll();

        List<StudentDto> result = new ArrayList<>();
        for (Student student: students) {
            StudentDto studentDto = StudentMapper.studentMapper.toDto(student);
            TeacherDto teacherDto = teacherService.getTeacherById(student.getTeacher().getId());
            studentDto.setTeacher(teacherDto);

            result.add(studentDto);
        }

        return result;
    }

//    @Override
//    public List<Student> getStudentByAge(int age) {
//        return studentDao.fetchByAgeV2(age);
//    }


}

package com.spring.dao;


import com.spring.model.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface TeacherDao extends JpaRepository<Teacher, Long> {


}

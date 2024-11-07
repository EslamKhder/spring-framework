package com.spring.dao;

import com.spring.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentDao extends JpaRepository<Student, Long> {

    List<Student> findByName(String name);
    List<Student> findByNameContains(String letters); // "%ffs%"

    List<Student> findByTeacherId(Long id);
}

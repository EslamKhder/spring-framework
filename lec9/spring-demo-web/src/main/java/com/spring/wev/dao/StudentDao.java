package com.spring.wev.dao;

import com.spring.wev.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentDao extends JpaRepository<Student, Long> {

    List<Student> findByName(String name);
    List<Student> findByNameContains(String letters); // "%ffs%"

    @Query(value = "SELECT s FROM Student s WHERE s.age = :age", nativeQuery = false)
    List<Student> fetchByAgeV1(@Param("age") int age);

    @Query(value = "SELECT * from student where AGE = :age", nativeQuery = true)
    List<Student> fetchByAgeV2(@Param("age") int age);

    @Query(value = "SELECT avg(age) from student", nativeQuery = true)
    Double getAvgOfAge();
}

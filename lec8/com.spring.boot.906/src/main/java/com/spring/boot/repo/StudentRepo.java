package com.spring.boot.repo;

import com.spring.boot.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface StudentRepo extends JpaRepository<Student, Long> {

    // nativeQuery true
    // nativeQuery false
//    @Query(value = "select * from Student WHERE name = :name", nativeQuery = true)
    @Query(value = "select stu from Student stu WHERE stu.name = :name")
    List<Student> extractByName(@Param("name") String name);

    Optional<Student> findByUserName(String userName);
}

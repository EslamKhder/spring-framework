package com.spring.boot908.repo;

import com.spring.boot908.model.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TeacherRepo extends JpaRepository<Teacher, Long> {

    // query direct DB
    // query based on class ====> db
//    @Query(value = "select * from TEACHER where USER_NAME = :userName", nativeQuery = true)
    @Query(value = "select t from Teacher t where t.userName = :userName")
    Optional<Teacher> extractByUserName(@Param("userName") String userName);
}

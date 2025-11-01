package com.spring.boot.repo;

import com.spring.boot.model.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface TeacherRepo extends JpaRepository<Teacher, Long> {

    Optional<Teacher> findByUserName(String userName);

    // native    - true   -false
//    @Query(value = "select * from Teacher where USER_NAME = :username", nativeQuery = true)
//    @Query(value = "select t from Teacher t where t.userName = :username")
//    Teacher extractByUserName(@Param("username") String userName);


//    List<Teacher> findByUserNameContainingIgnoreCase(String userName);
//
//    List<Teacher> findByUserNameStartingWithIgnoreCase(String userName);
//    List<Teacher> findByUserNameEndWithIgnoreCase(String userName);
}

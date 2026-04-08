package com.spring.demo.repo;

import com.spring.demo.model.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TeacherRepo extends JpaRepository<Teacher, Long> {

    Teacher findByUserName(String userName); //  Teacher  List<Teacher>
    Teacher findByUserNameAndPassword(String userName, String password);
    Teacher findByUserNameOrPassword(String userName, String password); // Teacher   List<Teacher>
    List<Teacher> findByFirstNameOrderByFirstNameDesc(String firstName);
    List<Teacher> findByFirstNameStartingWith(String prefix);
    List<Teacher> findByFirstNameStartingWithOrderByFirstNameAsc(String prefix);

//    @Query(value = "select t from Teacher t where t.userName = :userName")
//    Teacher extractByUserName(@Param("userName") String userName);

    //@Query(value = "select t from Teacher t where t.userName = :userName")
    @Query(value = "select * from Teacher where USER_NAME = :userName", nativeQuery = true)
    Teacher extractByUserName(@Param("userName")String userName);
}

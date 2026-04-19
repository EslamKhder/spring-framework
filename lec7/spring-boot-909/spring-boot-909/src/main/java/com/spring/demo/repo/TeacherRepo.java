package com.spring.demo.repo;

import com.spring.demo.model.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface TeacherRepo extends JpaRepository<Teacher, Long> {

    Optional<Teacher> findByUserName(String userName); //  Optional<Teacher>  List<Teacher>
    Optional<Teacher> findByUserNameAndPassword(String userName, String password);
    Optional<Teacher> findByUserNameOrPassword(String userName, String password); // Optional<Teacher>   List<Teacher>
    List<Teacher> findByFirstNameOrderByFirstNameDesc(String firstName);
    List<Teacher> findByFirstNameStartingWith(String prefix);
    List<Teacher> findByFirstNameStartingWithOrderByFirstNameAsc(String prefix);

//    @Query(value = "select t from Optional<Teacher> t where t.userName = :userName")
//    Optional<Teacher> extractByUserName(@Param("userName") String userName);

    //@Query(value = "select t from Optional<Teacher> t where t.userName = :userName")
    @Query(value = "select * from Optional<Teacher> where USER_NAME = :userName", nativeQuery = true)
    Optional<Teacher> extractByUserName(@Param("userName")String userName);
}

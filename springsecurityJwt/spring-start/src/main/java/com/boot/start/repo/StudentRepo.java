package com.boot.start.repo;

import com.boot.start.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepo extends JpaRepository<Student, Integer> {

    List<Student> findByName(String name);


//    @Query(value = "select s from Student s where s.address like %:address%")
    @Query(value = "select * from student where FULL_ADDRESS like %:address%", nativeQuery = true)
    List<Student> extractStudentsByAddressContaining(@Param("address") String address);

}

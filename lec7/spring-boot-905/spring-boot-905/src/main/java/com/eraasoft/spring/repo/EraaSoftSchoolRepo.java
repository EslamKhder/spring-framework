package com.eraasoft.spring.repo;

import com.eraasoft.spring.model.EraaSoftSchool;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.chrono.Era;
import java.util.List;
import java.util.Optional;

@Repository
public interface EraaSoftSchoolRepo extends JpaRepository<EraaSoftSchool, Long> {

    Optional<EraaSoftSchool> findByUserName(String userName);

    //nativeQuery = true   DB ORACLE
    //nativeQuery = false  default Based on Model
    @Query(value = "select * from Eraa_Soft_School where USER_NAME=:userName", nativeQuery = true)
//    @Query(value = "select ess from EraaSoftSchool ess where ess.userName = :userName")
    Optional<EraaSoftSchool> extractByUserName(@Param("userName") String userName);
    // DB ORACLE
    // MODEL
}

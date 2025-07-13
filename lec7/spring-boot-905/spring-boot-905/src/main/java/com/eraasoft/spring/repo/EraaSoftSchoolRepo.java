package com.eraasoft.spring.repo;

import com.eraasoft.spring.model.EraaSoftSchool;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EraaSoftSchoolRepo extends JpaRepository<EraaSoftSchool, Long> {

    EraaSoftSchool findByUserName(String userName);
}

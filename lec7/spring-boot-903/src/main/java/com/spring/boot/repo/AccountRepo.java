package com.spring.boot.repo;

import com.spring.boot.model.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface AccountRepo extends JpaRepository<Account, Long> {

    Optional<Account> findByUserName(String userName);

    List<Account> findByUserNameContainingIgnoreCase(String keyword);

    @Query(value = "SELECT * FROM Account WHERE PHONE_NUMBER LIKE CONCAT(CONCAT( '%', :ph), '%')", nativeQuery = true)
    List<Account> findByAccountPhoneV1(@Param("ph") String phone);

    @Query(value = "SELECT a FROM Account a WHERE a.phoneNumber LIKE CONCAT(CONCAT( '%', :ph), '%')")
    List<Account> findByAccountPhoneV2(@Param("ph") String phone);
}

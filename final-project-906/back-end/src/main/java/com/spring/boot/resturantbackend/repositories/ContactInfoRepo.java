package com.spring.boot.resturantbackend.repositories;

import com.spring.boot.resturantbackend.models.ContactInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContactInfoRepo extends JpaRepository<ContactInfo, Long> {
}

package com.spring.boot.resturantbackend.models;

import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedBy;

@MappedSuperclass
@Getter
@Setter
public class PublicData extends BaseEntity {

    private String value;
}

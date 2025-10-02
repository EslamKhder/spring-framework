package com.spring.boot.dto;

import com.spring.boot.model.Student;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RoleDto {

    private Long id;

    private String name;


}

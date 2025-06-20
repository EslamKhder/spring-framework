package com.spring.core;

import org.springframework.stereotype.Component;

@Component("teacher")
public class TeacherService implements SchoolService {
    @Override
    public void printData() {
        System.out.println("hi Teacher");
    }
}

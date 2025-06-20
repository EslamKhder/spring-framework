package com.spring.core;

public class TeacherService implements SchoolService {
    @Override
    public void printData() {
        System.out.println("hi Teacher");
    }
}

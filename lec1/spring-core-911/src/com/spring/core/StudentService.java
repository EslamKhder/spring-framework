package com.spring.core;

public class StudentService implements SchoolService {
    @Override
    public void startApp() {
        System.out.println("startApp student");
    }
}

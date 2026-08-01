package com.spring.core;

public class TeacherService implements SchoolService {
    @Override
    public void startApp() {
        System.out.println("startApp Teacher");
    }
}

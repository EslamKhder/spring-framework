package com.sring.core;

import org.springframework.stereotype.Component;

//@Component
public class PublicSchoolImpl implements SchoolService{
    @Override
    public void getStudent() {
        System.out.println("get Public School Impl");
    }
}

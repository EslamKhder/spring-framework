package com.sring.core;

import org.springframework.stereotype.Component;

@Component
public class PrivateSchoolImpl implements SchoolService{
    @Override
    public void getStudent() {
        System.out.println("get Private School Impl");
    }
    
    
}

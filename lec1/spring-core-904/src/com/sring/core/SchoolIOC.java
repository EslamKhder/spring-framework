package com.sring.core;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class SchoolIOC {
	
    private SchoolService schoolService;

    //
   /*public SchoolIOC(@Qualifier("publicSchoolImpl") SchoolService schoolService){
        this.schoolService = schoolService;
    }*/
//    public SchoolIOC(){
//        schoolService = new PublicSchoolImpl();
//    }

    void printStudentData(){
        schoolService.getStudent();
    }
    /*public void setSchoolService(SchoolService schoolService) {
        this.schoolService = schoolService;
    }*/
}

//  
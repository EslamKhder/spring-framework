package com.spring.core.ioc;

import com.spring.core.SchoolService;

public class SchoolAppService {

    private SchoolService schoolService;

    /*public SchoolAppService(SchoolService schoolService) {
        this.schoolService = schoolService;
    }*/

    //setSchoolService      schoolService
    public void setSchoolService(SchoolService schoolService) {
        this.schoolService = schoolService;
    }
    
    public void run(){
        schoolService.startApp();
    }

}

package com.spring.core;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class SchoolAppService {

	/*@Autowired
	@Qualifier("employeeService")*/
    private SchoolService schoolService;

    //@Autowired
    public SchoolAppService(@Qualifier("myEmployeeService") SchoolService schoolService) {
        this.schoolService = schoolService;
    }

    public void run(){
        schoolService.startApp();
    }

    /*@Autowired
    public void setSchoolService(@Qualifier("employeeService") SchoolService schoolService) {
        this.schoolService = schoolService;
    }*/
     
}

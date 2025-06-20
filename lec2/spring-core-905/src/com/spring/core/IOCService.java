package com.spring.core;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component("iocService")
public class IOCService {

	
    private @Qualifier("student") SchoolService schoolService;
    
    

	void startApp() {
        schoolService.printData();
    }

}

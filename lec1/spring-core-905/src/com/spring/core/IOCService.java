package com.spring.core;

public class IOCService {

    private SchoolService schoolService;

    private String name;
    
    //schoolService
    public void setSchoolService(SchoolService schoolService) {
        this.schoolService = schoolService;
    }
    
    

    public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}



	void startApp() {
        schoolService.printData();
    }

}

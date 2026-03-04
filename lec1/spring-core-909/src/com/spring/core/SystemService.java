package com.spring.core;

public class SystemService {

    // private SchoolServiceSystem schoolServiceSystem = new TeacherServiceSystem();
    private SchoolServiceSystem schoolServiceSystem;

    

//  public SystemService(SchoolServiceSystem schoolServiceSystem) {
//      this.schoolServiceSystem = schoolServiceSystem;
//  }
    
    // setSchoolServiceSystem
    // SchoolServiceSystem
    // schoolServiceSystem
    public void setSchoolServiceSystem(SchoolServiceSystem schoolServiceSystem) {
        this.schoolServiceSystem = schoolServiceSystem;
    }


    public void start(){
        System.out.println("Application start.....");
        schoolServiceSystem.startApp();
        System.out.println("Application End.....");
    }
}

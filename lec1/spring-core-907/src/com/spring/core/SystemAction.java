package com.spring.core;

public class SystemAction {

    private BaseSystem baseSystem;

    /*public SystemAction(BaseSystem baseSystem) {
        this.baseSystem = baseSystem;
    }*/
    
    // setBaseSystem        BaseSystem            baseSystem            
    public void setBaseSystem(BaseSystem baseSystem) {
        this.baseSystem = baseSystem;
    }

    public void startApplication(){
        baseSystem.startSystem();
    }
}

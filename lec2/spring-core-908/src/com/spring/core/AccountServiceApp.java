package com.spring.core;

import org.springframework.stereotype.Component;

//@Component
public class AccountServiceApp implements ApplicationService {

    @Override
    public void startApp() {
        System.out.println("start app AccountServiceApp");
    }
}

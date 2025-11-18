package com.spring.boot.controller.vm;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class LoginRequestVM {

    private String userName;
    private String password;
}

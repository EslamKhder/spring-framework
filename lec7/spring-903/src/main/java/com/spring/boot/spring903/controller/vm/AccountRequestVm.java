package com.spring.boot.spring903.controller.vm;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class AccountRequestVm {

    private String userName;
    private String password;

}

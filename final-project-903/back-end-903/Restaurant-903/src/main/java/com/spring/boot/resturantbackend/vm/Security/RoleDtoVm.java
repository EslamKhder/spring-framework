package com.spring.boot.resturantbackend.vm.Security;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class RoleDtoVm {
    private Long id;
    private String code;

    public RoleDtoVm(String code) {
        this.code = code;
    }
}
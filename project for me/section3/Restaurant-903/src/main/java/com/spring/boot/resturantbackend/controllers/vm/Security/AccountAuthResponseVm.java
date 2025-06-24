package com.spring.boot.resturantbackend.controllers.vm.Security;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class AccountAuthResponseVm {
    private Long id;
    private String username;
    private String token;
    private List<String> userRoles;
}

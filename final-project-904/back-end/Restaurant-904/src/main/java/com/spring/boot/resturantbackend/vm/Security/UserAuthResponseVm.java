package com.spring.boot.resturantbackend.vm.Security;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class UserAuthResponseVm {
    private Long id;
    private String username;
    private String token;
}

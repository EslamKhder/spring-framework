package com.spring.boot.resturantbackend.vm.Security;
import com.fasterxml.jackson.annotation.JsonProperty;
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
    @JsonProperty("roles")
    private List<String> userRoles;
}

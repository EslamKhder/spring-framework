package com.spring.boot.dto;


import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;

@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class AccountDto extends BaseEntityDto implements Serializable {

    private Long id;

    @NotEmpty(message = "invalid.user.name")
    private String userName;

    @NotEmpty(message = "phone Number must be not null")
    @Size(min = 11, max = 11, message = "phone Number size must 12 digit")
    private String phoneNumber;

    //    @JsonIgnore
    @NotEmpty(message = "invalid password")
    private String password;


    private List<RoleDto> roles;
}

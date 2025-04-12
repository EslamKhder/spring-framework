package com.spring.boot.dto;


import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class AccountDto extends BaseEntityDto{

    private Long id;

    @NotEmpty(message = "invalid user name")
    private String userName;

    @NotEmpty(message = "invalid phone Number")
    @Size(min = 11, max = 11, message = "invalid phone Number")
    private String phoneNumber;

    private String length;
    //    @JsonIgnore
    @NotEmpty(message = "password")
    private String password;


}

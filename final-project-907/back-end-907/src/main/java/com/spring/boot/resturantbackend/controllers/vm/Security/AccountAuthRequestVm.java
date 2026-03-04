package com.spring.boot.resturantbackend.controllers.vm.Security;
import com.spring.boot.resturantbackend.annotations.PhoneNumber;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class AccountAuthRequestVm {
//    @NotEmpty()
//    @Size(min = 7, message = "size.username")
    private String username;
//    @Pattern(
//            regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[^a-zA-Z\\d]).{7,}$",
//            message = "error.password"
//    )
    private String password;

    @PhoneNumber
    private String phoneNumber;
}
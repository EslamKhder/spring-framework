package com.spring.boot.resturantbackend.vm.Security;
import com.spring.boot.resturantbackend.annotations.ValidPhone;
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
    private Long id;
    @NotEmpty(message = "not_empty.username")
    @Size(min = 7, message = "size.username")
    private String username;
    @Pattern(
            regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[^a-zA-Z\\d]).{7,}$",
            message = "error.password"

    )
    private String password;


    @ValidPhone(message = "phone must include bla bla bla")
    private String phoneNumber;// start with +20       1113903660

}

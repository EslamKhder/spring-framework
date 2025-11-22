package springdemo.finalprojectrestoran.dto.Jwt;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ClientLoginDto {

    private String email;
    private String password;
}

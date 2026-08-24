package start.group.demo910.dto;

import lombok.Getter;
import lombok.Setter;
import start.group.demo910.model.Roles;

import java.util.List;

@Getter
@Setter
public class AccountDto {

    private Long id;

    private String username;

    private String password;

    private List<RolesDto> roles;
}

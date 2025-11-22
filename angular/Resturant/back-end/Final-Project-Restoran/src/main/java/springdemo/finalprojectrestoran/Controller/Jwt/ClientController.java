package springdemo.finalprojectrestoran.Controller.Jwt;

import jakarta.transaction.SystemException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import springdemo.finalprojectrestoran.Service.Jwt.AuthService;
import springdemo.finalprojectrestoran.Service.Jwt.ClientService;
import springdemo.finalprojectrestoran.dto.Jwt.ClientDto;
import springdemo.finalprojectrestoran.dto.Jwt.ClientLoginDto;
import springdemo.finalprojectrestoran.dto.Jwt.TokenDto;

import java.net.URI;

@RestController
@RequestMapping("/client")
public class ClientController {

    @Autowired
   private AuthService authService;

    @Autowired
    private ClientService clientService;

    @PostMapping("/login")
    ResponseEntity<TokenDto>getlogin(@RequestBody ClientLoginDto clientLoginDto) throws SystemException {
       return ResponseEntity.ok(authService.login(clientLoginDto));
    }

    @PostMapping("/create-client")
    ResponseEntity<Void> createUser(@RequestBody ClientDto clientDto) throws SystemException {
        clientService.createUserClient(clientDto);
        return  ResponseEntity.created(URI.create("/client/addClientWithRole")).build();
    }


}

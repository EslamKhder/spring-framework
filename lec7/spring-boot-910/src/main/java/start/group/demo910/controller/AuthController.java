package start.group.demo910.controller;

import jakarta.transaction.SystemException;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import start.group.demo910.dto.AccountDto;
import start.group.demo910.dto.PlayerDto;
import start.group.demo910.service.AuthService;

import java.net.URI;
import java.net.URISyntaxException;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody @Validated AccountDto accountDto) throws URISyntaxException, SystemException {
        return ResponseEntity.ok(authService.login(accountDto));
    }
}

package com.spring.boot.controller.auth;

import com.spring.boot.controller.vm.TokenResponseVm;
import com.spring.boot.dto.AccountDto;
import com.spring.boot.dto.EmployeeDto;
import com.spring.boot.dto.exception.IdNotNullException;
import com.spring.boot.service.AuthService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.transaction.SystemException;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;

@Tag(
        name = "AuthController",
        description = "AuthController to create account and login to get token"
)
@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private AuthService authService;

    @Operation(
            summary = "signUp for create account",
            description = "signUp for create account with employeeDto"
    )
    @ApiResponses({
            @ApiResponse(
                    responseCode = "201",
                    description = "HTTP Status created"
            ),
            @ApiResponse(
                    responseCode = "500",
                    description = "HTTP Status Internal server error",
                    content = @Content(
                            schema = @Schema(implementation = IdNotNullException.class)
                    )
            )
    })
    @PostMapping("/sign-up")
    public ResponseEntity<Void> signUp(@RequestBody @Valid EmployeeDto employeeDto) throws SystemException, IdNotNullException {
        authService.signUp(employeeDto);
        return ResponseEntity.created(URI.create("/auth/sign-up")).build();
    }

    @PostMapping("/login")
    public ResponseEntity<TokenResponseVm> login(@RequestBody @Valid EmployeeDto employeeDto) throws SystemException{
        return ResponseEntity.ok(authService.login(employeeDto));
    }
}

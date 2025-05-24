package com.spring.boot.config;

import com.spring.boot.dto.EmployeeDto;
import com.spring.boot.helper.JwtToken;
import com.spring.boot.service.EmployeeService;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.JwtParser;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import jakarta.transaction.SystemException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.nio.charset.StandardCharsets;
import java.security.Key;
import java.time.Duration;
import java.util.Date;
import java.util.Objects;
import java.util.stream.Collectors;

@Component
public class TokenHandler {

    private String secretKey;
    private Duration time;

    private JwtBuilder jwtBuilder;

    private JwtParser jwtParser;

    @Autowired
    private EmployeeService employeeService;

    public TokenHandler(JwtToken jwtToken) {
        this.secretKey = jwtToken.getSecret();
        this.time = jwtToken.getTime();

        Key key = Keys.hmacShaKeyFor(secretKey.getBytes(StandardCharsets.UTF_8));
        jwtBuilder = Jwts.builder().signWith(key);
        jwtParser = Jwts.parserBuilder().setSigningKey(key).build();

    }

    public String createToken(EmployeeDto employee){
        Date issueDate = new Date();
        Date expirationDate = Date.from(issueDate.toInstant().plus(time));
        jwtBuilder.setSubject(employee.getUserName());
        jwtBuilder.setIssuedAt(issueDate);
        jwtBuilder.setExpiration(expirationDate);
        jwtBuilder.claim("roles", employee.getRoleDtos().stream().map(roleDto -> roleDto.getRoleName()).collect(Collectors.toList()));

        return jwtBuilder.compact();
    }

    public EmployeeDto validateToken(String token){
        try {
            if (jwtParser.isSigned(token)) {
                Claims claims = jwtParser.parseClaimsJws(token).getBody();
                String userName = claims.getSubject();
                Date issueDate = claims.getIssuedAt();
                Date expirationDate = claims.getExpiration();


                EmployeeDto employeeDto = employeeService.getEmployeeByUserName(userName);

                boolean isValidToken = Objects.nonNull(employeeDto) && expirationDate.after(new Date()) &&
                        issueDate.before(expirationDate);

                if (isValidToken) {
                    return employeeDto;
                }
            }
        } catch (SystemException e) {
            throw new RuntimeException(e);
        }
        return null;
    }
}

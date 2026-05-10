package com.spring.demo.service.token;

import com.spring.demo.dto.AccountDto;
import com.spring.demo.service.AccountService;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.JwtParser;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import jakarta.transaction.SystemException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import java.nio.charset.StandardCharsets;
import java.security.Key;
import java.time.Duration;
import java.util.Date;
import java.util.stream.Collectors;

@Component
public class JwtTokenHandler {

    private JwtBuilder jwtBuilder;

    private JwtParser jwtParser;

    private Duration time;

    @Autowired
    @Lazy
    private AccountService accountService;

    public JwtTokenHandler(@Value("${token.secret}") String secretKey, @Value("${token.time}") Duration time) {
        this.time = time;
        Key key = Keys.hmacShaKeyFor(secretKey.getBytes(StandardCharsets.UTF_8));
        jwtBuilder = Jwts.builder().signWith(key);
        jwtParser = Jwts.parserBuilder().setSigningKey(key).build();
    }

    public String createToken(AccountDto accountDto){
        Date issueDate = new Date();
        Date expiryDate = Date.from(issueDate.toInstant().plus(time));

        jwtBuilder.setSubject(accountDto.getUserName())
                .setIssuedAt(issueDate)
                .setExpiration(expiryDate)
                .claim("roles", accountDto.getRoles().stream().map(role -> role.getRole()).collect(Collectors.toList()));

        return jwtBuilder.compact();
    }

    public AccountDto validateToken(String token) {
        try {
            if (!jwtParser.isSigned(token)){
                return null;
            }

            Claims claims = jwtParser.parseClaimsJws(token).getBody();
            String userName = claims.getSubject();
            Date issueDate = claims.getIssuedAt();
            Date expiryDate = claims.getExpiration();

            AccountDto accountDto = accountService.getByUserName(userName);

            boolean isActiveToken = (issueDate.before(expiryDate) && expiryDate.after(new Date()));

            if (isActiveToken) {
                return accountDto;
            }

        } catch (Exception e) {
            return null;
        }

        return null;
    }

}

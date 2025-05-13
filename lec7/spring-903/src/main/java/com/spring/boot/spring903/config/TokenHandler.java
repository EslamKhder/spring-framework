package com.spring.boot.spring903.config;

import com.spring.boot.spring903.dto.AccountDto;
import com.spring.boot.spring903.service.AccountService;
import com.spring.boot.spring903.sitting.JwtToken;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.JwtParser;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import jakarta.transaction.SystemException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.nio.charset.StandardCharsets;
import java.security.Key;
import java.time.Duration;
import java.util.Date;
import java.util.Objects;

@Component
public class TokenHandler {

    private JwtBuilder jwtBuilder;

    private JwtParser jwtParser;

    private String secretKey;

    private Duration time;

    @Autowired
    private AccountService accountService;


    public TokenHandler(JwtToken jwtToken) {
        this.secretKey = jwtToken.getSecret();
        this.time = jwtToken.getTime();
        Key key = Keys.hmacShaKeyFor(secretKey.getBytes(StandardCharsets.UTF_8));
        jwtBuilder = Jwts.builder().signWith(key);
        jwtParser = Jwts.parserBuilder().setSigningKey(key).build();
    }

    /**
     * Create Token
     * @param account
     * @return
     */
    public String createToken(AccountDto account){
        Date issueDate = new Date();
        Date expirationDate = Date.from(issueDate.toInstant().plus(time));
        jwtBuilder.setSubject(account.getUserName());
        jwtBuilder.setIssuedAt(issueDate);
        jwtBuilder.setExpiration(expirationDate);

        return jwtBuilder.compact();
    }

    public AccountDto validateToken(String token) throws SystemException {
        if(jwtParser.isSigned(token)){

            Claims claims = jwtParser.parseClaimsJws(token).getBody();
            Date issueDate = claims.getIssuedAt();
            Date expirationDate = claims.getExpiration();

            AccountDto accountDto = accountService.getAccountByName(claims.getSubject());
            boolean isTokenValid =  expirationDate.after(new Date()) &&
                    issueDate.before(expirationDate) &&
                    Objects.nonNull(accountDto);

            if (isTokenValid) {
                return accountDto;
            }
        }

        return null;
    }

    public String getSubject(String token) throws SystemException {
        if(jwtParser.isSigned(token)){
            return jwtParser.parseClaimsJws(token).getBody().getSubject();
        }
        throw new SystemException("invalid token");
    }
}

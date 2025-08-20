package com.eraasoft.spring.service.token;

import com.eraasoft.spring.dto.AccountDto;
import com.eraasoft.spring.helper.JwtToken;
import com.eraasoft.spring.service.AccountService;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.JwtParser;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.nio.charset.StandardCharsets;
import java.security.Key;
import java.time.Duration;
import java.util.Date;
import java.util.Objects;
import java.util.stream.Collectors;

// TODO create token
// TODO validate token
@Component
public class TokenHandler {

    private String secretKey;

    private Duration time;

    private JwtBuilder jwtBuilder;

    private JwtParser jwtParser;

    @Autowired
    private AccountService accountService;

    // encoding
    public TokenHandler(JwtToken jwtToken){
        secretKey = jwtToken.getSecret();
        time = jwtToken.getTime();

        Key key = Keys.hmacShaKeyFor(secretKey.getBytes(StandardCharsets.UTF_8));
        jwtBuilder = Jwts.builder().signWith(key);
        jwtParser = Jwts.parserBuilder().setSigningKey(key).build();
    }

    public String createToken(AccountDto accountDto){
        Date issueDate = new Date();
        Date expirationDate = Date.from(issueDate.toInstant().plus(time));

        jwtBuilder.setSubject(accountDto.getUserName());
        jwtBuilder.setIssuedAt(issueDate);
        jwtBuilder.setExpiration(expirationDate);
        jwtBuilder.claim("address", accountDto.getAddress());
        jwtBuilder.claim("roles", accountDto.getRoles().stream().map(roleDto -> roleDto.getRoleName()).collect(Collectors.toList()));

        return jwtBuilder.compact();
    }

    public AccountDto validateToken(String token){
        if (jwtParser.isSigned(token)){
            Claims claims = jwtParser.parseClaimsJws(token).getBody();
            String userName = claims.getSubject();
            Date issueDate = claims.getIssuedAt();
            Date expirationDate = claims.getExpiration();

            AccountDto accountDto = accountService.getByUserName(userName);

            boolean isValidToken = Objects.nonNull(accountDto)
                                    && expirationDate.after(new Date())
                                    && issueDate.before(expirationDate);

            if (!isValidToken) {
                return null;
            }

            return accountDto;
        }

        return null;
    }
}

package com.spring.config.jwt;


import com.spring.model.Auth;
import com.spring.model.Client;
import com.spring.sitting.TokenConfig;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.JwtParser;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.nio.charset.StandardCharsets;
import java.security.Key;
import java.time.Duration;
import java.util.Date;

@Component
public class TokenHandler {

    private JwtBuilder jwtBuilder;

    private JwtParser jwtParser;

    private String secret;

    private Duration timeExpired;

    @Autowired
    public TokenHandler(TokenConfig tokenConfig) {
        secret = tokenConfig.getSecret();
        timeExpired = tokenConfig.getTime();

        Key key = Keys.hmacShaKeyFor(secret.getBytes(StandardCharsets.UTF_8));
        jwtBuilder = Jwts.builder().signWith(key);
        jwtParser = Jwts.parserBuilder().setSigningKey(key).build();
    }

    public String createToken(Client client) {
        Date issues = new Date();

        for (Auth auth :client.getAuths()) {
            auth.setClient(null);
        }

        Date expirationDate = Date.from(issues.toInstant().plus(timeExpired));
        return jwtBuilder.setSubject(client.getEmail())
                .setIssuedAt(issues)
                .setExpiration(expirationDate)
                .claim("name", client.getName())
                .claim("roles", client.getAuths()).compact();
    }

    public boolean isValidToken(String token){
        if (jwtParser.isSigned(token)){
            Claims claims = jwtParser.parseClaimsJws(token).getBody();

            Date issue = claims.getIssuedAt();
            Date expired = claims.getExpiration();

            return expired.after(new Date()) && issue.before(expired);
        }

        return false;
    }

    public String getSubject(String token){
        return jwtParser.parseClaimsJws(token).getBody().getSubject();
    }
}

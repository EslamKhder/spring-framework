package com.boot.start.config;

import com.boot.start.model.Employee;
import com.boot.start.model.Role;
import com.boot.start.sittings.TokenConfig;
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
import java.time.Instant;
import java.util.Date;

@Component
public class JwtTokenHandler {

    private JwtBuilder jwtBuilder;
    private JwtParser jwtParser;

    private String secret;

    private Duration timeExpired;


    @Autowired
    public JwtTokenHandler(TokenConfig tokenConfig) {
        this.secret = tokenConfig.getSecret();
        this.timeExpired = tokenConfig.getTime();
        Key key =  Keys.hmacShaKeyFor(secret.getBytes(StandardCharsets.UTF_8));
        jwtBuilder = Jwts.builder().signWith(key);
        jwtParser = Jwts.parserBuilder().setSigningKey(key).build();

    }

    public String createToken(Employee employee){

        for(Role role: employee.getRoles()){
            role.setEmployee(null);
        }

        // build the claims
        Date issuesDate = new Date(); // current date
        Instant instant = issuesDate.toInstant().plus(timeExpired);
        Date dateOfExpired = Date.from(instant); // calculate the expired date starting from issueDate

        return jwtBuilder.setSubject(employee.getName())
                .setIssuedAt(issuesDate)
                .setExpiration(dateOfExpired)
                .claim("roles", employee.getRoles()).compact();
    }

    public boolean validateToken(String token) {

        //  check if the token is created by the system or  not
        if (jwtParser.isSigned(token)) {

            // check if the token is valid
            Claims claims = jwtParser.parseClaimsJws(token).getBody();
            Date issue = claims.getIssuedAt();
            Date expired = claims.getExpiration();


            return expired.after(new Date()) && issue.before(expired);
        }

        return false;
    }
}

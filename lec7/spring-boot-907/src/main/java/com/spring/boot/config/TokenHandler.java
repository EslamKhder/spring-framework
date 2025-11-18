package com.spring.boot.config;

import com.spring.boot.dto.TeacherDto;
import com.spring.boot.helper.JwtToken;
import com.spring.boot.service.TeacherService;
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
    private Duration duration;

    private JwtBuilder jwtBuilder;

    private JwtParser jwtParser;

    @Autowired
    private TeacherService teacherService;

    public TokenHandler(JwtToken jwtToken) {
        duration = jwtToken.getTime();

        Key key = Keys.hmacShaKeyFor(jwtToken.getSecret().getBytes(StandardCharsets.UTF_8));
        jwtBuilder = Jwts.builder().signWith(key);
        jwtParser = Jwts.parserBuilder().setSigningKey(key).build();
    }

    public String createToken(TeacherDto teacherDto) {
        Date issueDate = new Date();
        Date expiryDate = Date.from(issueDate.toInstant().plus(duration));

        String token = jwtBuilder.setSubject(teacherDto.getUserName()) // Subject   eslam
                .setIssuedAt(issueDate) // iss
                .setExpiration(expiryDate)
                .claim("myName", teacherDto.getMyName())
                .claim("roles", teacherDto.getRoles().stream().map(roleDto -> roleDto.getCode()).collect(Collectors.toList()))
                .compact();

        return token;
    }

    public TeacherDto validateToken(String token) throws SystemException {
        if (!jwtParser.isSigned(token)) {
            return null;
        }

        Claims claims = jwtParser.parseClaimsJws(token).getBody();

        String userName = claims.getSubject();
        Date issuedAt = claims.getIssuedAt();
        Date expiration = claims.getExpiration();

        TeacherDto teacherDto = teacherService.getByUserName(userName);

        boolean isValidToken =  Objects.nonNull(teacherDto) && expiration.after(new Date()) && issuedAt.before(expiration);

        if (isValidToken){
            return teacherDto;
        }

        return null;
    }
}

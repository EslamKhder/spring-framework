package com.spring.boot908.config.jwt;

import com.spring.boot908.dto.TeacherDto;
import com.spring.boot908.helper.JwtToken;
import com.spring.boot908.service.TeacherService;
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
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Component
public class TokenHandler {
    private String secret;

    private Duration time;

    private JwtBuilder jwtBuilder;

    private JwtParser jwtParser;

    @Autowired
    private TeacherService teacherService;

    public TokenHandler(JwtToken jwtToken){
        this.secret = jwtToken.getSecret();
        this.time = jwtToken.getTime();

        Key key = Keys.hmacShaKeyFor(secret.getBytes(StandardCharsets.UTF_8));
        jwtBuilder = Jwts.builder().signWith(key);
        jwtParser = Jwts.parserBuilder().setSigningKey(key).build();
    }


    public String createToken(TeacherDto teacherDto){
        Date issueData = new Date(); // 1/11/2025
        Date expiryData = Date.from(issueData.toInstant().plus(time)); // 1/12/2025

        jwtBuilder.setSubject(teacherDto.getUserName());
        jwtBuilder.setIssuedAt(issueData);
        jwtBuilder.setExpiration(expiryData);
        jwtBuilder.claim("gender", teacherDto.getGender());
        List<String> roles = teacherDto.getRoles().stream().map(roleDto -> roleDto.getCode()).collect(Collectors.toList());
        jwtBuilder.claim("roles", roles);

        return jwtBuilder.compact();
    }


    public TeacherDto validateToken(String token){
        try {
            if (!jwtParser.isSigned(token)) {
                return null;
            }

            Claims claims = jwtParser.parseClaimsJws(token).getBody();
            Date issueData = claims.getIssuedAt(); // 1/11/2025
            Date expiryData = claims.getExpiration();// 1/12/2025
            String userName = claims.getSubject();

            TeacherDto teacherDto = teacherService.getTeacherByUserName(userName);


            boolean isActiveToken = expiryData.after(issueData) &&  expiryData.after(new Date());

            if (isActiveToken && Objects.nonNull(teacherDto)) {
                return teacherDto;
            }

            return null;
        } catch (Exception exception) {
            return null;
        }
    }




}

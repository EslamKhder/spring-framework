package com.spring.boot.config.jwt;

import com.spring.boot.dto.StudentDto;
import com.spring.boot.helper.JwtToken;
import com.spring.boot.service.StudentService;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.JwtParser;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
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

    private StudentService studentService;

    public TokenHandler(JwtToken jwtToken, StudentService studentService){
        this.studentService = studentService;
        this.secret = jwtToken.getSecret();
        this.time = jwtToken.getTime();

        Key key = Keys.hmacShaKeyFor(secret.getBytes(StandardCharsets.UTF_8));

        jwtBuilder = Jwts.builder().signWith(key);
        jwtParser = Jwts.parserBuilder().setSigningKey(key).build();
    }

    public String createToken(StudentDto studentDto){
        // issue date
        Date issueDate = new Date();
        Date expiryDate = Date.from(issueDate.toInstant().plus(time));

        jwtBuilder.setSubject(studentDto.getUserName());
        jwtBuilder.setIssuedAt(issueDate);
        jwtBuilder.setExpiration(expiryDate);

        jwtBuilder.claim("name", studentDto.getName());
        List<String> roles = studentDto.getRoles().stream().map(roleDto -> roleDto.getName()).collect(Collectors.toList());
        jwtBuilder.claim("roles",roles);

        return jwtBuilder.compact();
    }


    public StudentDto validateToken(String token){

        if (jwtParser.isSigned(token)) {

            Claims claims = jwtParser.parseClaimsJws(token).getBody();

            String userName = claims.getSubject();
            Date issueDate = claims.getIssuedAt();
            Date expiryDate = claims.getExpiration();

            StudentDto studentDto  = studentService.getStudentsByUserName(userName);

            boolean isValidToken =  Objects.nonNull(studentDto) &&
                                    expiryDate.after(new Date()) &&
                                    issueDate.before(expiryDate);

            if (isValidToken) {
                return studentDto;
            }

        }

        return null;
    }


}

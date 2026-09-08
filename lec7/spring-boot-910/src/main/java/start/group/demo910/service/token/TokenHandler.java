package start.group.demo910.service.token;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.JwtParser;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import jakarta.transaction.SystemException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import start.group.demo910.dto.AccountDto;
import start.group.demo910.service.AccountService;

import javax.xml.crypto.Data;
import java.nio.charset.StandardCharsets;
import java.security.Key;
import java.time.Duration;
import java.util.Date;
import java.util.Objects;
import java.util.stream.Collectors;

@Component
public class TokenHandler {
    @Value("${token.time}")
    private Duration duration;

    private JwtBuilder jwtBuilder;

    private JwtParser jwtParser;

    @Autowired
    private AccountService accountService;

    public TokenHandler(@Value("${token.secret}") String secret) {
        Key key = Keys.hmacShaKeyFor(secret.getBytes(StandardCharsets.UTF_8));
        jwtBuilder = Jwts.builder().signWith(key);
        jwtParser = Jwts.parserBuilder().setSigningKey(key).build();
    }

    public String createToken(AccountDto accountDto){

        Date issuedAt = new Date();
        Date expiration = Date.from(issuedAt.toInstant().plus(duration));
        jwtBuilder.setSubject(accountDto.getUsername());
        jwtBuilder.setIssuedAt(issuedAt);
        jwtBuilder.setExpiration(expiration);
        jwtBuilder.setId(accountDto.getId().toString());
        jwtBuilder.claim("roles", accountDto.getRoles().stream().map(rolesDto -> rolesDto.getName()).collect(Collectors.toList()));

        return jwtBuilder.compact();
    }

    public AccountDto validateToken(String token){
        try {
            if (!jwtParser.isSigned(token)) {
                return null;
            }
            Claims claims = jwtParser.parseClaimsJws(token).getBody();
            String userName = claims.getSubject();
            Date issuedAt = claims.getIssuedAt();
            Date expiration = claims.getExpiration();

            AccountDto accountDto = accountService.getAccountByUser(userName);

            boolean isValidToken = Objects.nonNull(accountDto) &&
                    expiration.after(new Date()) && issuedAt.before(expiration);

            if(isValidToken){
                return accountDto;
            }

        } catch (SystemException e) {
            System.out.println("ex: " + e.toString());
            return null;
        }

        return null;
    }
}

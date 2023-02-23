package id.co.dansmultipro.javadevelopertest.util;

import id.co.dansmultipro.javadevelopertest.entity.User;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import org.springframework.stereotype.Component;

import javax.crypto.SecretKey;
import java.nio.charset.StandardCharsets;
import java.util.Date;

@Component
public class JWTUtil {

    public static String generateAccessToken(User user) {
        SecretKey secretKey = Keys.hmacShaKeyFor("secret".getBytes(StandardCharsets.UTF_8));

        return Jwts.builder()
                .setSubject(user.getUsername())
                .setIssuedAt(new Date())
                .signWith(secretKey)
                .compact();
    }

}

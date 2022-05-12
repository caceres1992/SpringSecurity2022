package com.example.springsecurityv2.jwt;

import com.example.springsecurityv2.security.CustomUserDetails;
import io.jsonwebtoken.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
@Slf4j
public class JwtUtils {

    @Value("${jwt.secret.expire}")
    private long jwtExpirationMs;

    @Value("${jwt.secret}")
    private String jwtSecret;


    public String generateJwtToken(CustomUserDetails userDetails) {
//        Llamar al metodo de generarf token con el username
        return generateToken(userDetails.getUsername());
    }

    //    Generar Token con el nombre de usuario
    public String generateToken(String username) {

        return Jwts.builder().setSubject(username)
                .setIssuedAt(new Date())
                .setExpiration(new Date(new Date().getTime() + (jwtExpirationMs * 60) * 10))
                .signWith(SignatureAlgorithm.HS512, jwtSecret)
                .compact();
    }

    //    Obtener el nombre de usuario del token
    public String getUsernameFromToken(String token) {
        return Jwts.parser()
                .setSigningKey(jwtSecret)
                .parseClaimsJws(token)
                .getBody()
                .getSubject();
    }

    //    Verificar si el token es valido
    public boolean validateToken(String authToken) {
        try {
            Jwts.parser().setSigningKey(jwtSecret).parseClaimsJws(authToken);
            return true;
        } catch (SignatureException e) {
            log.error("JwtUtils | validateJwtToken | Invalid Jwt Signature: {} ", e.getMessage());
        } catch (MalformedJwtException e) {
            log.error("JwtUtils | validateJwtToken | Invalid Jwt Token: {} ", e.getMessage());
        } catch (ExpiredJwtException e) {
            log.error("JwtUtils | validateJwtToken | Expired Jwt Token: {} ", e.getMessage());
        } catch (UnsupportedJwtException e) {
            log.error("JwtUtils | validateJwtToken | Unsupported Jwt Token: {} ", e.getMessage());
        } catch (IllegalArgumentException e) {
            log.error("JwtUtils | validateJwtToken | Invalid Jwt Token: {} ", e.getMessage());
        }
        return false;


    }
}

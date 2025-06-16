package com.alfis.procurement.auth.security;

import io.jsonwebtoken.*;
import io.jsonwebtoken.security.Keys;
import org.springframework.stereotype.Component;

import java.security.Key;
import java.util.Date;
import java.util.UUID;

@Component
public class JwtTokenProvider {

    private final String secretKey = "ThisIsASecretKeyThatShouldBeStoredSecurely1234567890";
    private final long expiration = 1000 * 60 * 60 * 24; // 24 jam

    private final Key key = Keys.hmacShaKeyFor(secretKey.getBytes());

    public String generateToken(UUID userId, String email, String role) {
        return Jwts.builder()
                .setSubject(userId.toString())
                .claim("email", email)
                .claim("role", role)
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + expiration))
                .signWith(key, SignatureAlgorithm.HS256)
                .compact();
    }

    public Jws<Claims> validateToken(String token) {
        return Jwts.parserBuilder().setSigningKey(key).build().parseClaimsJws(token);
    }

    public UUID getUserIdFromToken(String token) {
        return UUID.fromString(validateToken(token).getBody().getSubject());
    }

    public String getEmailFromToken(String token) {
        return validateToken(token).getBody().get("email", String.class);
    }

    public String getRoleFromToken(String token) {
        return validateToken(token).getBody().get("role", String.class);
    }
}

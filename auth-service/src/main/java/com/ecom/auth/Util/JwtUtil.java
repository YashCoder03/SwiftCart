package com.ecom.auth.Util;

import java.util.Date;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
@Component
public class JwtUtil {

    @Value("${jwt.secret}")
    private String secret;
    @Value("${jwt.expiration-ms}")
    private long expiryTime;

    public String generateToken(String email,String role, String userId){
        
        Date date = new Date();
        Date expiryDate = new Date(date.getTime() + expiryTime);
        Claims claim = Jwts.claims();
        claim.put("role",role);
        claim.put("email",email);
        claim.put("id",userId);
        System.out.println(userId);
        return Jwts.builder()
                .setSubject(userId)
                .setClaims(claim)
                .setIssuedAt(new Date())
                .setExpiration(expiryDate)
                .signWith(Keys.hmacShaKeyFor(secret.getBytes()),SignatureAlgorithm.HS256)
                .compact();
    }

}

package com.opencejav.LibMaster.authentication;

import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import io.jsonwebtoken.Jwts;

import java.util.Date;

public class JwtService {
    @Value("${jwt}")
    private static String key;

    public static String generateToken (String username) {
        System.out.println(key);
        return Jwts.builder()
                .setSubject(username)
                .setExpiration(new Date(System.currentTimeMillis() + 800000000))
                .signWith(SignatureAlgorithm.HS256, "")
                .compact();
    }

    public static String decyption (String token) {
        return Jwts
                .parser()
                .setSigningKey("")
                .build()
                .parseSignedClaims((CharSequence)token)
                .getBody()
                .toString();
    }
}
package com.tms.Auth_API.security;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class AuthUtility {

    @Value("${token.expirationTime}")
    Long expirationTime;

    @Value("${security.secretPassword}")
    String secretPassword;

    public String generateToken(String email,
                                String password,
                                String role){
        String payload = email + ":" + password + ":" + role;
        String jwtToken = Jwts.builder()
                .setExpiration(new Date(System.currentTimeMillis() + expirationTime))
                .setIssuedAt(new Date())
                .signWith(SignatureAlgorithm.HS256, secretPassword)
                .setSubject(payload)
                .compact();
        return jwtToken;
    }

    /**
     * This method is responsible for decrypting the token and taking out the encrypted payload
     * @param token
     * @return
     */
    public String decryptJwtToken(String token){
        String payload = Jwts.parser().setSigningKey(secretPassword)
                .parseClaimsJws(token)
                .getBody()
                .getSubject();
        return payload;
    }

    public boolean validateToken(String token){
        return true;//Write the logic after
    }

}

package com.tms.Auth_API.security.security;

import com.tms.Auth_API.security.model.Employee;
import com.tms.Auth_API.security.service.UserService;
import io.jsonwebtoken.*;
import io.jsonwebtoken.security.Keys;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.crypto.SecretKey;
import java.nio.charset.StandardCharsets;
import java.util.Base64;
import java.util.Date;

@Service
public class AuthUtility {

    private final UserService userService;
    private final PasswordEncoder passwordEncoder;
    private SecretKey secretKey;
    
    @Value("${token.expirationTime}")
    private Long expirationTime;

    @Value("${security.secretPassword}")
    private String secretPassword;

    @Autowired
    public AuthUtility(UserService userService) {
        this.userService = userService;
        this.passwordEncoder = new BCryptPasswordEncoder();
    }

    @PostConstruct
    public void init() {
        if (secretPassword == null || secretPassword.length() < 32) {
            throw new IllegalStateException("security.secretPassword must be at least 32 characters long");
        }
        // Ensure the secret key is at least 256 bits (32 characters)
        String base64Key = Base64.getEncoder().encodeToString(secretPassword.getBytes(StandardCharsets.UTF_8));
        this.secretKey = Keys.hmacShaKeyFor(base64Key.getBytes(StandardCharsets.UTF_8));
    }

    public String generateToken(String email, String password, String role) {
        validateInput(email, password, role);
        
        String hashedPassword = passwordEncoder.encode(password);
        String payload = email + ":" + hashedPassword + ":" + role;
        
        try {
            return Jwts.builder()
                    .setExpiration(new Date(System.currentTimeMillis() + expirationTime))
                    .setIssuedAt(new Date())
                    .signWith(secretKey, SignatureAlgorithm.HS256)
                    .setSubject(payload)
                    .compact();
        } catch (JwtException e) {
            throw new SecurityException("Failed to generate token: " + e.getMessage(), e);
        }
    }

    public String decryptJwtToken(String token) {
        if (!StringUtils.hasText(token)) {
            throw new IllegalArgumentException("Token cannot be null or empty");
        }

        try {
            return Jwts.parserBuilder()
                    .setSigningKey(secretKey)
                    .build()
                    .parseClaimsJws(token)
                    .getBody()
                    .getSubject();
        } catch (ExpiredJwtException e) {
            throw new SecurityException("Token has expired", e);
        } catch (JwtException e) {
            throw new SecurityException("Invalid token", e);
        }
    }

    public boolean validateToken(String token) {
        if (!StringUtils.hasText(token)) {
            return false;
        }

        try {
            String payload = this.decryptJwtToken(token);
            String[] data = payload.split(":");
            
            if (data.length != 3) {
                return false;
            }
            
            String email = data[0];
            String hashedPassword = data[1];
            
            Employee employee = userService.getUserDetails(email);
            if (employee == null) {
                return false;
            }

            return passwordEncoder.matches(employee.getPassword(), hashedPassword);
            
        } catch (SecurityException e) {
            return false;
        }
    }
    
    private void validateInput(String... inputs) {
        for (String input : inputs) {
            if (!StringUtils.hasText(input)) {
                throw new IllegalArgumentException("Input parameters cannot be null or empty");
            }
        }
    }
}

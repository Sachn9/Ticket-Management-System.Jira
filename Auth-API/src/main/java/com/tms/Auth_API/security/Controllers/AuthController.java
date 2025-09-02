package com.tms.Auth_API.security.Controllers;

import com.tms.Auth_API.security.dto.UserDetails;
import com.tms.Auth_API.security.security.AuthUtility;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/auth/")
public class AuthController {

    AuthUtility authUtility;

    @Autowired
    public AuthController(AuthUtility authUtility){
        this.authUtility=authUtility;
    }

    @GetMapping("/token")
    public String generateToken(@RequestBody UserDetails userDetails){
        String token=authUtility.generateToken(userDetails.getEmail(),userDetails.getPassword(),userDetails.getRole());
        return token;
    }

    @GetMapping("/validate")
    public String tokenValidate(@RequestHeader String authorization){

        String token=authorization.substring(7);
        return authUtility.validateToken(token)? "Valid" : "InValid";
    }
}

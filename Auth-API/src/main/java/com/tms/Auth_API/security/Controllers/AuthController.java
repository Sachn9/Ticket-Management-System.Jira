package com.tms.Auth_API.security.Controllers;

import com.tms.Auth_API.security.dto.UserDetails;
import com.tms.Auth_API.security.model.Employee;
import com.tms.Auth_API.security.security.AuthUtility;
import com.tms.Auth_API.security.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/auth/")
public class AuthController {

    AuthUtility authUtility;
    UserService userService;

    @Autowired
    public AuthController(AuthUtility authUtility,
                          UserService userService){
        this.authUtility=authUtility;
        this.userService=userService;
    }

    @PostMapping("/token")
    public String generateToken(@RequestBody UserDetails userDetails){
        String token=authUtility.generateToken(userDetails.getEmail(),userDetails.getPassword(),userDetails.getRole());
        return token;
    }

    @GetMapping("/validate/{operation}")
    public Employee tokenValidate(@RequestHeader String authorization,
                                  @RequestParam String opName){

        String token=authorization.substring(7);

        //Authentication chk
        if(!authUtility.validateToken(token)){
            return null;
        }

        String email=authUtility.decryptJwtToken(token).split("")[0];

        //Authorization chk
        return userService.isHavingAccess(email,opName);
    }
}

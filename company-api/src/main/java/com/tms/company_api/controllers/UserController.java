package com.tms.company_api.controllers;

import com.tms.company_api.dto.UserLoginDto;
import com.tms.company_api.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


//es User ki alg api hogE but sir ne time ki vjeH se ese me bna de h
@RestController
@RequestMapping("/api/v1/user")
public class UserController {

    UserService userService;
    @Autowired
    public UserController(UserService userService){
        this.userService=userService;
    }

    @GetMapping("/login")
    public String loginUser(@RequestBody UserLoginDto userLoginDto){

        //user service
        String token=userService.loginUser(userLoginDto);
        return token;
    }
}

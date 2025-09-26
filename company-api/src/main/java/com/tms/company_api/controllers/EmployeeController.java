package com.tms.company_api.controllers;

import com.tms.company_api.dto.InviteEmployeeDto;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/employee")
public class EmployeeController {

    @PostMapping("/invite")
    public String inviteEmployee(@RequestBody InviteEmployeeDto inviteEmployeeDto,
                                 @RequestHeader String token){

    }
}

package com.tms.notification_api.notification_api.controllers;

import com.tms.notification_api.notification_api.models.Employee;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/notify/employee")
public class EmployeeController {

    @PutMapping("/invite")
    public void inviteEmployee(@RequestBody Employee employee){
        //employeeService

    }
}

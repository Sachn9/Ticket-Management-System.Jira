package com.tms.db.Database_Api.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/api/v1/db/employee")
public class EmployeeController {

    @GetMapping("/{employeeId}")
    public ResponseEntity getEmployeeById(@PathVariable UUID employeeId){

        //As we don't have Writes any logic we can  Directly call the repository layer
        

    }
}

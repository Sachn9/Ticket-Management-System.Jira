package com.tms.db.Database_Api.controllers;

import com.tms.db.Database_Api.models.Employee;
import com.tms.db.Database_Api.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.UUIDEditor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;


@RestController
@RequestMapping("/api/v1/db/employee")
public class EmployeeController {

    EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeController(EmployeeRepository employeeRepository){
        this.employeeRepository=employeeRepository;
    }

    //authUtility email verification
    @GetMapping("/email/{emailId}")
    public  ResponseEntity getEmployeeById(@PathVariable String emailId){
        Employee employee=employeeRepository.findByEmployeeEmail(emailId);
        return new ResponseEntity<>(employee,HttpStatus.OK);

    }


    @GetMapping("/id/{employeeId}")
    public ResponseEntity getEmployeeById(@PathVariable UUID employeeId){

        //As we don't have Writes any logic we can  Directly call the repository layer

        Employee employee=employeeRepository.findById(employeeId).orElse(null);
        return new ResponseEntity<>(employee, HttpStatus.OK);

    }

    @PostMapping("/create")
    public ResponseEntity createEmployee(@RequestBody Employee employee){
        employeeRepository.save(employee);
        return new ResponseEntity<>(employee,HttpStatus.CREATED);
    }

    @PutMapping("/update")
    public ResponseEntity updateEmployee(@RequestBody Employee employee){
        employeeRepository.save(employee);
        return new ResponseEntity<>(employee,HttpStatus.OK);
    }

    @DeleteMapping("/delete/{employeeId}")
    public ResponseEntity deleteEmployee(@PathVariable UUID employeeId){
        employeeRepository.deleteById(employeeId);
        return new ResponseEntity<>(HttpStatus.OK);
    }


}

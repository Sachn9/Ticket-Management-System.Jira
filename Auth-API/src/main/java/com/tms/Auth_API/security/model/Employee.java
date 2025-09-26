package com.tms.Auth_API.security.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.management.relation.Role;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Employee {

    private Long employeeId;

    private Company company;  //it should be relation with the company model

    private String employeeName;

    private String employeeEmail;

    private String phoneNumber;

    private Role role;

    private String password;

    private String gender;

    private String address;

    private String status;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;

    private Employee createdBy;

    private Employee updateBy;
}

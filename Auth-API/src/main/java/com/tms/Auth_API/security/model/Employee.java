package com.tms.Auth_API.security.model;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class Employee {

    private Long employeeId;

    private Company company;  //it should be relation with the company model

    private String employeeName;

    private String employeeEmail;

    private String phoneNumber;

    private String password;

    private String gender;

    private String address;

    private String status;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;

    private Employee createdBy;

    private Employee updateBy;
}

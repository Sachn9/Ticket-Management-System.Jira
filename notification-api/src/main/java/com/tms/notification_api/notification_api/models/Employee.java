package com.tms.notification_api.notification_api.models;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Employee {
    private Long id;

    private Company company;  //it should be relation with the company model

    private String employeeName;

    private Role role;

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

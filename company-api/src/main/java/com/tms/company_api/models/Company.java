package com.tms.company_api.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Company {
    private Long companyId;

    private String companyName;

    private String companyOfficialName;

    private String address;

    private String companySize;

    private String companyLogo; // Can store URL or Base64 string

    private Employee adminId;  //It should be relationship with the employee model

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;

    private Employee createdBy;

    private Employee updateBy;
}

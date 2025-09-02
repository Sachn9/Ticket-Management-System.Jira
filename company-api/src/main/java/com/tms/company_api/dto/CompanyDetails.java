package com.tms.company_api.dto;

import lombok.Data;

@Data
public class CompanyDetails {
    private String companyName;

    private String companyOfficialName;

    private String companySize;

    private String companyLogo;

    private String adminName;

    private String adminEmail;

    private String phoneNumber;

    private String password;

    private String gender;

    private String address;
}

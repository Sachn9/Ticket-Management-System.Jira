package com.tms.company_api.controllers;

import com.tms.company_api.dto.CompanyDetails;
import com.tms.company_api.services.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/company")
public class CompanyController {

    CompanyService companyService;
    @Autowired
    public CompanyController(CompanyService companyService){
        this.companyService=companyService;
    }

    /**
     *
     * Work this method is register to company inside the company table
     */

    @PostMapping("/register")
    public void registerCompany(@RequestBody CompanyDetails companyDetails){

        companyService.registerCompany(companyDetails);
    }
}

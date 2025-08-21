package com.tms.db.Database_Api.controllers;

import com.tms.db.Database_Api.models.Company;
import com.tms.db.Database_Api.repository.CompanyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/api/v1/db/company")
public class CompanyController {

    private final CompanyRepository companyRepository;

    @Autowired
    public CompanyController(CompanyRepository companyRepository) {
        this.companyRepository = companyRepository;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Company> getCompanyById(@PathVariable UUID id) {
        Company company = companyRepository.findById(id).orElse(null);
        return new ResponseEntity<>(company, HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<Company> createCompany(@RequestBody Company company) {
        companyRepository.save(company);
        return new ResponseEntity<>(company, HttpStatus.CREATED);
    }

    @PutMapping("/update")
    public ResponseEntity<Company> updateCompany(@RequestBody Company company) {
        companyRepository.save(company);
        return new ResponseEntity<>(company, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteCompany(@PathVariable UUID id) {
        companyRepository.deleteById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}

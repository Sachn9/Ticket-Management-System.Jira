package com.tms.db.Database_Api.models;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "companies")
public class Company {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long companyId;

    @Column(unique = true)
    private String companyName;

    @Column(unique = true)
    private String companyOfficialName;

    private String address;

    private String companySize;

    private String companyLogo; // Can store URL or Base64 string

    @OneToOne
    private Employee adminId;  //It should be relationship with the employee model

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;

    @ManyToOne
    private Employee createdBy;

    @ManyToOne
    private Employee updateBy;
}

package com.tms.db.Database_Api.models;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "employees")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long employeeId;

    @ManyToOne
    private Company company;  //it should be relation with the company model

    private String employeeName;

    @Column(unique = true, nullable = false)
    private String employeeEmail;

    @Column(unique = true,nullable = false)
    private String phoneNumber;

    private String password;

    private String gender;

    private String address;

    private String status;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;

    @ManyToOne
    private Employee createdBy;

    @ManyToOne
    private Employee updateBy;
}

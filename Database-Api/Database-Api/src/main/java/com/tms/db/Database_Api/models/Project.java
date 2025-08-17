package com.tms.db.Database_Api.models;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Data
@Entity
@Table(name="projects")
public class Project{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @ManyToOne
    private Company company; //it should be relationship with the company model

    @Column(unique = true)
    private String projectName;

    @OneToMany
    List<ProjectState> projectStates;

    private String description;

    @ManyToMany
    private List<Employee> employee;//it should be relationship with the employee model

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;

    @ManyToOne
    private Employee createdBy;

    @ManyToOne
    private Employee updateBy;
}

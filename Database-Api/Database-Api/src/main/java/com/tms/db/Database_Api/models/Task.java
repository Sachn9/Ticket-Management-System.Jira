package com.tms.db.Database_Api.models;

import jakarta.persistence.*;
import lombok.Data;

import java.security.PrivateKey;
import java.time.LocalDateTime;
import java.util.List;

@Data
@Entity
@Table(name="tasks")
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long taskId;

    @ManyToOne
    private Project project;  //It should be relationship with project model

    private String taskDescription;

    private String taskEngineeringDetails;

    private Integer points;

    @ManyToOne
    private Employee assign;//It should be relationship with Employee model

    @ManyToOne
    private ProjectState state;

    @OneToMany
    private List<Comment> comments;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;

    @ManyToOne
    private Employee createdBy;

    @ManyToOne
    private Employee updateBy;

}

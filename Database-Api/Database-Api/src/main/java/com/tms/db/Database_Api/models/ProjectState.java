package com.tms.db.Database_Api.models;

import jakarta.persistence.*;
import lombok.Data;
import org.springframework.core.annotation.Order;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
@Entity
@Table(name="project_states")
public class ProjectState {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    private String stateName;

    @Column(name="state_order")
    private Integer oder;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;

    @ManyToOne
    private Employee createdBy;

    @ManyToOne
    private Employee updateBy;
}

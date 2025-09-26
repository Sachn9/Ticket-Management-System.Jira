package com.tms.db.Database_Api.models;

import jakarta.persistence.*;
import lombok.Data;
import org.springframework.objenesis.instantiator.util.UnsafeUtils;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
@Entity
@Table(name = "operations")
public class Operation {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    private UUID id;

    @Column(unique = true)
    private String operationName;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;
}

package com.tms.Auth_API.security.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Role {

    private UUID id;

    private String roleName;

    private Company company;

    private List<Operation> operations;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;


}

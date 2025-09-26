package com.tms.notification_api.notification_api.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Role {

    private UUID roleId;

    private String roleName;

    private Company company;

    private List<Operation> operations;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;
}


package com.tms.Auth_API.security.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Operation {


    private UUID id;

    private String operationName;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;
}

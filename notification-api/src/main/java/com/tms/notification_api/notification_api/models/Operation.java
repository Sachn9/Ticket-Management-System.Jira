package com.tms.notification_api.notification_api.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Operation {

    private UUID id;

    private String operationName;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;
}

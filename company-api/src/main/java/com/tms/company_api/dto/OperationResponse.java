package com.tms.company_api.dto;

import com.tms.company_api.models.Operation;
import lombok.Data;

import java.lang.management.OperatingSystemMXBean;
import java.util.List;

@Data
public class OperationResponse {
    List<Operation> operations;
}

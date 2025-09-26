package com.tms.db.Database_Api.dto;

import com.tms.db.Database_Api.models.Operation;
import lombok.Data;

import java.util.List;

@Data
public class OperationResponse {
    List<Operation> operations;
}

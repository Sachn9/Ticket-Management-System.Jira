package com.tms.company_api.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class InviteEmployeeDto {

    private String employeeName;

    private String employeeEmail;

    private String phoneNumber;

    private UUID role;//Many employee having one role

    private String password;

    private String gender;

    private String address;

}

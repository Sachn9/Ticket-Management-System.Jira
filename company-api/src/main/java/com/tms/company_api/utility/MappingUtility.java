package com.tms.company_api.utility;

import com.tms.company_api.dto.CompanyDetails;
import com.tms.company_api.dto.InviteEmployeeDto;
import com.tms.company_api.enums.EmployeeEnum;
import com.tms.company_api.models.Company;
import com.tms.company_api.models.Employee;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class MappingUtility {

    public Company mapCompanyDtoToCompanyModel(CompanyDetails companyDetails, Employee admin) {

        Company company=Company.builder()
                .companyName(companyDetails.getCompanyName())
                .companyOfficialName(companyDetails.getCompanyOfficialName())
                .companyLogo(companyDetails.getCompanyLogo())
                .companySize(companyDetails.getCompanySize())
                .createdAt(LocalDateTime.now())
                .updatedAt(LocalDateTime.now())
                .createdBy(admin)
                .updateBy(admin)
                .adminId(admin)
                .build();
                return company;
    }

    public Employee mapEmployeeDetailsToEmployeeModel(CompanyDetails companyDetails){
        Employee employee=Employee.builder()
                .employeeName(companyDetails.getAdminName())
                .employeeEmail(companyDetails.getAdminEmail())
                .phoneNumber(companyDetails.getPhoneNumber())
                .password(companyDetails.getPassword())
                .gender(companyDetails.getGender())
                .address(companyDetails.getAddress())
                .createdAt(LocalDateTime.now())
                .updatedAt(LocalDateTime.now())
                .build();
        return employee;
    }

    public Employee mapToEmployeeDtoToEmployee(InviteEmployeeDto inviteEmployeeDto,Company company){
        Employee employee=Employee.builder()
                .employeeName(inviteEmployeeDto.getEmployeeName())
                .employeeEmail(inviteEmployeeDto.getEmployeeEmail())
                .address(inviteEmployeeDto.getAddress())
                .gender(inviteEmployeeDto.getGender())
                .password("Pass@1")
                .status(EmployeeEnum.INACTIVE.toString())
                .phoneNumber(inviteEmployeeDto.getPhoneNumber())
                .company(company)
                .createdAt(LocalDateTime.now())
                .updatedAt(LocalDateTime.now())
                .build();
        return employee;
    }

}

package com.tms.company_api.services;

import com.tms.company_api.connectores.AuthApiConnector;
import com.tms.company_api.connectores.DataBaseApiConnector;
import com.tms.company_api.dto.InviteEmployeeDto;
import com.tms.company_api.exception.InvalidCredentialException;
import com.tms.company_api.models.Employee;
import com.tms.company_api.utility.MappingUtility;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService {

    DataBaseApiConnector dataBaseApiConnector;
    AuthApiConnector authApiConnector;
    MappingUtility mappingUtility;
    @Autowired
    public EmployeeService(DataBaseApiConnector dataBaseApiConnector,
                           AuthApiConnector authApiConnector,
                           MappingUtility mappingUtility){
        this.dataBaseApiConnector=dataBaseApiConnector;
        this.authApiConnector=authApiConnector;
        this.mappingUtility=mappingUtility;
    }

    public Employee inviteEmployee(InviteEmployeeDto inviteEmployeeDto,String token){
        //verify token
        //call AutApiConnector ->verify token
        String opName="invite-employee";
        Employee adminEmployee=authApiConnector.generateToken(opName,token);

        if(adminEmployee==null){
            throw new InvalidCredentialException("User token is inValid");
        }

        //if user token is correct then map EmployeeDto to Employee Model
        Employee employee=mappingUtility.mapToEmployeeDtoToEmployee(inviteEmployeeDto,adminEmployee.getCompany());
        //we need to this employee in the dataBase
        employee=this.createEmployee(employee);
        //Send Invitation email
        //Notification-API -> we should call the notification api to invite employee for the organization


    }

    public Employee createEmployee(Employee employee){
        return dataBaseApiConnector.callCreateEmployeeEndsPoint(employee);
    }
}

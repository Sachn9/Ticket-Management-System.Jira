package com.tms.Auth_API.security.service;

import com.tms.Auth_API.security.connectores.DatabaseApiConnector;
import com.tms.Auth_API.security.model.Employee;
import com.tms.Auth_API.security.model.Operation;
import com.tms.Auth_API.security.model.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    DatabaseApiConnector databaseApiConnector;

    @Autowired
    public UserService(DatabaseApiConnector databaseApiConnector){

        this.databaseApiConnector=databaseApiConnector;
    }

    public Employee getUserDetails(String email){

        return databaseApiConnector.callGetEmployeeByEmailEndsPoint(email);
    }

    public Employee isHavingAccess(String email,String operationName){
        Employee employee=this.getUserDetails(email);
        Role role=employee.getRole();
        List<Operation> operations=role.getOperations();
        for(Operation operation : operations){
            if(operation.getOperationName().equals(operationName)){
                return employee;
            }
        }
        return null;
    }
}

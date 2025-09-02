package com.tms.Auth_API.security.service;

import com.tms.Auth_API.security.connectores.DatabaseApiConnector;
import com.tms.Auth_API.security.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
}

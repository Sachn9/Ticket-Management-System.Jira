package com.tms.company_api.services;

import com.tms.company_api.connectores.DataBaseApiConnector;
import com.tms.company_api.models.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService {

    DataBaseApiConnector dataBaseApiConnector;
    @Autowired
    public EmployeeService(DataBaseApiConnector dataBaseApiConnector){
        this.dataBaseApiConnector=dataBaseApiConnector;
    }

    public Employee createEmployee(Employee employee){
        return dataBaseApiConnector.callCreateEmployeeEndsPoint(employee);
    }
}

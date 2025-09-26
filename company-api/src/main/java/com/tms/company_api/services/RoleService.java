package com.tms.company_api.services;

import com.tms.company_api.connectores.DataBaseApiConnector;
import com.tms.company_api.models.Operation;
import com.tms.company_api.models.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class RoleService {

    DataBaseApiConnector dataBaseApiConnector;
    @Autowired
    public RoleService(DataBaseApiConnector dataBaseApiConnector){
        this.dataBaseApiConnector=dataBaseApiConnector;
    }

    public Role createCompanyAdminRole(String companyName){

        //Before creating role first we need to get all the operations that can role perform;
        //In company api how we can get all the operations
        //All the operation are registered in the database.
        //So,that means we need to get all the operations from the database.
        //Now in company api we can't directly interact with the database.
        //So,that means we need to all database api.
        //So,to call database api we need to database api connector.

        //CompanyName->Google
        List<Operation> operations=dataBaseApiConnector.callGetAllOperationEndPoint();
        String roleName=companyName+"_Admin";//ex:accio_Amin,Google_Admin
        Role role=Role.builder()
                .roleName(roleName)
                .operations(operations)
                .createdAt(LocalDateTime.now())
                .updatedAt(LocalDateTime.now())
                .build();
        //we need save the role inside role table
        //again we need to call database api connector

        return createOrUpdate(role);
    }
    public Role createOrUpdate(Role role){
        return dataBaseApiConnector.callCreateRoleEndPoint(role);
    }
}

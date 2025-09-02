package com.tms.company_api.services;

import com.tms.company_api.connectores.DataBaseApiConnector;
import com.tms.company_api.models.Company;
import com.tms.company_api.utility.MappingUtility;
import com.tms.company_api.dto.CompanyDetails;
import com.tms.company_api.models.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CompanyService {

    MappingUtility mappingUtility;
    EmployeeService employeeService;
    DataBaseApiConnector dataBaseApiConnector;
    @Autowired
    public CompanyService(MappingUtility mappingUtility,
                          EmployeeService employeeService,
                          DataBaseApiConnector dataBaseApiConnector){
        this.mappingUtility=mappingUtility;
        this.employeeService=employeeService;
        this.dataBaseApiConnector=dataBaseApiConnector;
    }

    public void registerCompany(CompanyDetails companyDetails){
        //First of all we will create Company model and DTO
        //By which we could map to both.
        //After that we need to app admin details to employee model
        Employee admin=mappingUtility.mapEmployeeDetailsToEmployeeModel(companyDetails);
        //And I need to save this employee inside the Employee table
        //(Yh work alg api ka h but sir Ne ese me krvA dya hm ese different api me bhi kr sKte h kiOki sir Ke Pass TIme km tha)

        //Database Api connector-> JokI HmAre database Employee create wale endsPoint ko call Kar Ske

        admin=employeeService.createEmployee(admin);

        //now I need to map companyDetails to company model
        Company company=mappingUtility.mapCompanyDtoToCompanyModel(companyDetails,admin);
        //Now I need to save this company inside the company table
        //save company object inside company table
        company=this.createCompany(company);
        admin.setCompany(company);
        this.employeeService.createEmployee(admin);

    }

    public Company createCompany(Company company){
        return dataBaseApiConnector.callCreateCompanyEndPoint(company);
    }
}

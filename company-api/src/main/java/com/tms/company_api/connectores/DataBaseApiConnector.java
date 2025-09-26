package com.tms.company_api.connectores;

import com.tms.company_api.dto.OperationResponse;
import com.tms.company_api.models.Company;
import com.tms.company_api.models.Employee;
import com.tms.company_api.models.Operation;
import com.tms.company_api.models.Role;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Component
public class DataBaseApiConnector {

    @Value("${database.api.url}")
    String databaseUrl;

    public Employee callCreateEmployeeEndsPoint(Employee employee){
        String url=databaseUrl + "/employee/create";
        RequestEntity requestEntity=RequestEntity.post(url).body(employee);
        RestTemplate restTemplate=new RestTemplate();
        ResponseEntity<Employee> responseEntity=restTemplate.exchange(url, HttpMethod.POST,requestEntity,Employee.class);

        return responseEntity.getBody();
    }

    public Company callCreateCompanyEndPoint(Company company){
        String url=databaseUrl+ "/company/create";
        RequestEntity requestEntity=RequestEntity.post(url).body(company);
        RestTemplate restTemplate=new RestTemplate();
        ResponseEntity<Company> responseEntity=restTemplate.exchange(url, HttpMethod.POST,requestEntity,Company.class);
        return responseEntity.getBody();

    }

    /**
     *
     * If you willSee we are not having any method to get all operation from the database api.
     */

    public List<Operation> callGetAllOperationEndPoint(){
            String url=databaseUrl + "/operation/all";
            RequestEntity requestEntity=RequestEntity.get(url).build();
            RestTemplate restTemplate=new RestTemplate();
            ResponseEntity<OperationResponse> responseEntity=restTemplate.exchange(url,HttpMethod.GET,requestEntity,OperationResponse.class);
            return responseEntity.getBody().getOperations();
    }

    public Role callCreateRoleEndPoint(Role role){
        String url=databaseUrl + "/role/create";
        RequestEntity requestEntity=RequestEntity.get(url).build();
        RestTemplate restTemplate=new RestTemplate();
        ResponseEntity<Role> responseEntity=restTemplate.exchange(url,HttpMethod.POST,requestEntity,Role.class);
        return responseEntity.getBody();
    }

    public Employee callGetEmployeeByEmailEndsPoint(String email){
        String url=databaseUrl + "/employee/email" + email;
        RequestEntity requestEntity=RequestEntity.get(url).build();
        RestTemplate restTemplate=new RestTemplate();
        ResponseEntity<Employee> responseEntity=restTemplate.exchange(url,HttpMethod.GET,requestEntity,Employee.class);
        return responseEntity.getBody();
    }
}

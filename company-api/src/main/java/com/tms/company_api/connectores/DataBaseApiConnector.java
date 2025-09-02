package com.tms.company_api.connectores;

import com.tms.company_api.models.Company;
import com.tms.company_api.models.Employee;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

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
}

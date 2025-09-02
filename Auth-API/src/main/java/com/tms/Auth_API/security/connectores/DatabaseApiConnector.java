package com.tms.Auth_API.security.connectores;

import com.tms.Auth_API.security.model.Employee;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpMethod;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

/**
 *
 * This class is responsible for calling different endsPoints of dataBaseApi
 */
@Component
public class DatabaseApiConnector {

    @Value("${database.api.url}")
    String dataBaseApiBaseUrl;

    /**
     * Work this function is to make call to databaseApi endPoint
     * /api/v1/db/employee/{emailId}
     * and get the employee details
     * @param email
     * @return
     */
    public Employee callGetEmployeeByEmailEndsPoint(String email){
        //create URL
        String url=dataBaseApiBaseUrl + "/employee/email/" +email;

        //create RequestEntity
        RequestEntity request = RequestEntity.get(url).build();
        //make call to database api
        RestTemplate restTemplate=new RestTemplate();
        ResponseEntity<Employee> response=restTemplate.exchange(url, HttpMethod.GET,request, Employee.class);
        return response.getBody();

    }
}

package com.tms.company_api.connectores;

import com.tms.company_api.dto.UserDetailsDto;
import com.tms.company_api.models.Company;
import com.tms.company_api.models.Employee;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class AuthApiConnector {

    @Value("${auth.api.url}")
    String authApiUrl;

    public String generateToken(UserDetailsDto userDetailsDto){
        String url=authApiUrl + "/token";
        RequestEntity requestEntity=RequestEntity.post(url).body(userDetailsDto );
        RestTemplate restTemplate=new RestTemplate();
        ResponseEntity<String> responseEntity=restTemplate.exchange(url, HttpMethod.POST,requestEntity,String.class);
        return responseEntity.getBody();
    }

    public Employee validToken(String token,String opName){
        String url=authApiUrl + "/validate" + opName;
        String bearerToken="Bearer" + token;
        HttpHeaders httpHeaders=new HttpHeaders();
        httpHeaders.add("Authorization",bearerToken);
        HttpEntity httpEntity=new HttpEntity<>(httpHeaders);
        RestTemplate restTemplate=new RestTemplate();
        ResponseEntity<Employee> responseEntity=restTemplate.exchange(url,HttpMethod.GET,httpEntity,Employee.class);
        return  responseEntity.getBody();
    }
}

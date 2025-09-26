package com.tms.company_api.services;

import com.tms.company_api.connectores.AuthApiConnector;
import com.tms.company_api.connectores.DataBaseApiConnector;
import com.tms.company_api.dto.UserDetailsDto;
import com.tms.company_api.dto.UserLoginDto;
import com.tms.company_api.models.Employee;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    DataBaseApiConnector dataBaseApiConnector;
    AuthApiConnector authApiConnector;
    @Autowired
    public UserService(DataBaseApiConnector dataBaseApiConnector,
                       AuthApiConnector authApiConnector){
        this.dataBaseApiConnector=dataBaseApiConnector;
        this.authApiConnector=authApiConnector;
    }

    public String loginUser(UserLoginDto userLoginDto){
        //we should call database api and get user by email
        Employee employee=dataBaseApiConnector.callGetEmployeeByEmailEndsPoint(userLoginDto.getEmail());
        if(employee==null){
            return "User_Not_Found";
        }

        if(!employee.getPassword().equals(userLoginDto.getPassWord())){
            return "Invalid_Password";
        }

        UserDetailsDto userDetailsDto=new UserDetailsDto(employee.getEmployeeEmail(),employee.getPassword(),employee.getRole().getRoleId().toString());
        //Generate JWT token -> call auth api
        String token=authApiConnector.generateToken(userDetailsDto);

        return token;

    }
}

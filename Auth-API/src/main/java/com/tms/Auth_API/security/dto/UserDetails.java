package com.tms.Auth_API.security.dto;

import lombok.Data;

@Data
public class UserDetails {

    String email;
    String password;
    String role;
}

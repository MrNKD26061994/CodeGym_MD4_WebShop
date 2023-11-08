package com.codegym.md4_webshop.payload.request;

import lombok.Data;
import lombok.Getter;

@Data
public class LoginRequest {
    private String userName ;
    private String password;
}

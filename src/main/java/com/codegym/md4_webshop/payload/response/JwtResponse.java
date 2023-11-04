package com.codegym.md4_webshop.payload.response;

import lombok.Getter;

import java.util.List;

@Getter
public class JwtResponse {
    private String token;
    private String type = "Bearer";
    private int userId;
    private String userName;
    private String email;
    private String phone;
    private List<String> listRole;

    public JwtResponse(String token, int userId, String userName, String email, String phone, List<String> listRole) {
        this.token = token;
        this.userId = userId;
        this.userName = userName;
        this.email = email;
        this.phone = phone;
        this.listRole = listRole;
    }

    public JwtResponse(String token, String userName, String email, String phone, List<String> listRole) {
        this.token = token;
        this.userName = userName;
        this.email = email;
        this.phone = phone;
        this.listRole = listRole;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setListRole(List<String> listRole) {
        this.listRole = listRole;
    }
}

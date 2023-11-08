package com.codegym.md4_webshop.payload.response;

import lombok.Getter;

import java.util.List;

@Getter
public class JwtResponse {
    private String token;
    private String type = "Bearer";
    private Long userId;
    private String username;
    private String email;
    private String phone;
    private List<String> listRole;

    public JwtResponse(String token, Long userId, String username, String email, String phone, List<String> listRole) {
        this.token = token;
        this.userId = userId;
        this.username = username;
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

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public void setUsername(String username) {
        this.username = username;
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

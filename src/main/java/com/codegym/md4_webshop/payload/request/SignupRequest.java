package com.codegym.md4_webshop.payload.request;

import lombok.Getter;
import org.hibernate.annotations.CreationTimestamp;


import java.time.LocalDateTime;
import java.util.Set;

@Getter
public class SignupRequest {
    private String username;
    private String password;
    private String email;
    private String phone;
    @CreationTimestamp
    private LocalDateTime create;
    private int userStatus;
    private Set<String> listRole;
    private String address;

    public SignupRequest(String username, String password, String email) {
        this.username = username;
        this.password = password;
        this.email = email;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setCreate(LocalDateTime create) {
        this.create = create;
    }

    public void setUserStatus(int userStatus) {
        this.userStatus = userStatus;
    }

    public void setListRole(Set<String> listRole) {
        this.listRole = listRole;
    }
}

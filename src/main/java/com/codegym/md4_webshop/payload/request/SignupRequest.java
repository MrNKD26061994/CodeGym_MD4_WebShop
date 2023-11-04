package com.codegym.md4_webshop.payload.request;

import lombok.Getter;
import org.hibernate.annotations.CreationTimestamp;


import java.time.LocalDateTime;
import java.util.Set;

@Getter
public class SignupRequest {
    private String userName;
    private String password;
    private String email;
    private String phone;
    @CreationTimestamp
    private LocalDateTime create;
    private int userStatus;
    private Set<String> listRole;
    private String address;

    public SignupRequest(String userName, String password, String email, String phone, Set<String> listRole) {
        this.userName = userName;
        this.password = password;
        this.email = email;
        this.phone = phone;
        this.listRole = listRole;
        this.userStatus = 1;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setUserName(String userName) {
        this.userName = userName;
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

package com.codegym.md4_webshop.model;

import com.codegym.md4_webshop.model.base.BaseModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import java.time.LocalDate;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User extends BaseModel {
    private String name;
    private String username;
    private String password;
    private String email;
    private String address;
    private String phone;
    private String image;
    private LocalDate birthday;
    private int gender;

    @ManyToOne
    private Role role;
}

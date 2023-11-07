package com.codegym.md4_webshop.model;

import com.codegym.md4_webshop.model.base.BaseModel;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@EqualsAndHashCode(callSuper = true)
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

    @JoinTable(name = "user_role",
            joinColumns = @JoinColumn(name = "id_user"),
            inverseJoinColumns = @JoinColumn(name = "id_role"))
    @ManyToMany(fetch = FetchType.LAZY)
    private Set<Role> advertisementSet = new HashSet<>();

}

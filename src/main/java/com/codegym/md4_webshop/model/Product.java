package com.codegym.md4_webshop.model;

import com.codegym.md4_webshop.model.base.BaseModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Product extends BaseModel {

    private String name;
    private double price;
    private int quantity;
    private int discount;
    private String description;

    @ManyToOne
    private Category category;

    @ManyToOne
    private Company company;

    @ManyToOne
    private User user;

}

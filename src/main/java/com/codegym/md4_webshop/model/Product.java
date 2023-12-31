package com.codegym.md4_webshop.model;

import com.codegym.md4_webshop.model.base.BaseModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Product{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private int status;
    private String name;
    private double price;
    private int quantity;
    private int discount;
    private String description;
    private String gender;
    @ManyToOne
    private Category category;

    @ManyToOne
    private Company company;

    @ManyToOne
    private User user;

    @OneToMany
    @JoinColumn(name = "product_id")
    private List<Image> imageList;

    public Product(Long id, double price) {
        this.id = id;
        this.price = price;
    }

    public Product(Long id, int quantity) {
        this.id = id;
        this.quantity = quantity;
    }

    public Product(Long id, double price, int quantity) {
        this.id = id;
        this.price = price;
        this.quantity = quantity;
    }

    public Product(int status, String name, double price, int quantity, int discount, String description, Category category, Company company, User user) {
        this.status = status;
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.discount = discount;
        this.description = description;
        this.category = category;
        this.company = company;
        this.user = user;
    }

    public Product(String name) {
        this.name = name;
    }

    public Product(double price) {
        this.price = price;
    }

    public Product(Category category) {
        this.category = category;
    }

    public Product(String name, double price, Category category) {
        this.name = name;
        this.price = price;
        this.category = category;
    }
}

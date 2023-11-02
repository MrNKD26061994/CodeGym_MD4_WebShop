package com.codegym.md4_webshop.model;

public class ForPayment {
    private Long id;
    private double price;
    private  int quantity;

    public ForPayment() {
    }

    public ForPayment(Long id, double price) {
        this.id = id;
        this.price = price;
    }

    public ForPayment(Long id, int quantity) {
        this.id = id;
        this.quantity = quantity;
    }

    public ForPayment(Long id, double price, int quantity) {
        this.id = id;
        this.price = price;
        this.quantity = quantity;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}

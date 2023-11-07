package com.codegym.md4_webshop.model.oderProduct;

public class SearchOBJ {
    private double num1;
    private double num2;
    private Long id;
    private String name;

    public SearchOBJ(double num1, double num2) {
        this.num1 = num1;
        this.num2 = num2;
    }

    public SearchOBJ(Long catagory_id) {
        this.id = catagory_id;
    }

    public SearchOBJ(String name) {
        this.name = name;
    }

    public SearchOBJ() {
    }

    public SearchOBJ(double num1, double num2, Long id, String name) {
        this.num1 = num1;
        this.num2 = num2;
        this.id = id;
        this.name = name;
    }

    public SearchOBJ(double num1, double num2, Long id) {
        this.num1 = num1;
        this.num2 = num2;
        this.id = id;
    }

    public SearchOBJ(double num1, double num2, String name) {
        this.num1 = num1;
        this.num2 = num2;
        this.name = name;
    }

    public SearchOBJ(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public double getNum1() {
        return num1;
    }

    public void setNum1(double num1) {
        this.num1 = num1;
    }

    public double getNum2() {
        return num2;
    }

    public void setNum2(double num2) {
        this.num2 = num2;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

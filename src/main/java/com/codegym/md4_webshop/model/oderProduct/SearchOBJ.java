package com.codegym.md4_webshop.model.oderProduct;

public class SearchOBJ {
    private Long num1;
    private Long num2;
    private Long id;
    private String name;

    public SearchOBJ(Long num1, Long num2) {
        this.num1 = num1;
        this.num2 = num2;
    }

    public SearchOBJ(Long id) {
        this.id = id;
    }

    public SearchOBJ(String name) {
        this.name = name;
    }

    public SearchOBJ() {
    }

    public SearchOBJ(Long num1, Long num2, Long id, String name) {
        this.num1 = num1;
        this.num2 = num2;
        this.id = id;
        this.name = name;
    }

    public SearchOBJ(Long num1, Long num2, Long id) {
        this.num1 = num1;
        this.num2 = num2;
        this.id = id;
    }

    public SearchOBJ(Long num1, Long num2, String name) {
        this.num1 = num1;
        this.num2 = num2;
        this.name = name;
    }

    public SearchOBJ(Long id, String name) {
        this.id = id;
        this.name = name;
    }


    public Long getNum1() {
        return num1;
    }

    public void setNum1(Long num1) {
        this.num1 = num1;
    }

    public Long getNum2() {
        return num2;
    }

    public void setNum2(Long num2) {
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

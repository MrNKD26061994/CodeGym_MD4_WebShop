package com.codegym.md4_webshop.service;

import com.codegym.md4_webshop.model.Product;

import java.util.Optional;

public interface IProductService extends IGeneralService<Product> {
    boolean reduceQuantity(Long Id, int quantity);
    void reducePrice(Long Id, double price);
    Iterable<Product> searchByGender(String gender);

    Iterable<Product> searchProductByName(String name);

}

package com.codegym.md4_webshop.service;

import com.codegym.md4_webshop.model.Product;

import java.util.Optional;

public interface IProductService extends IGeneralService<Product> {
    Optional<Product> reduceQuantity(Long Id, int quantity);
    void reducePrice(Long Id, double price);

}

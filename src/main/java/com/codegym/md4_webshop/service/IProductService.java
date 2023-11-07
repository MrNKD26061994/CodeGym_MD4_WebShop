package com.codegym.md4_webshop.service;

import com.codegym.md4_webshop.model.Product;

public interface IProductService extends IGeneralService<Product> {
    void reduceQuantity(Long id, int quantity);

    void reducePrice(Long id, double price);

}

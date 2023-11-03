package com.codegym.md4_webshop.service;

import com.codegym.md4_webshop.model.Product;

public interface IProductService extends IGeneralService<Product> {
    void editQuantity(Long Id, int quantity);
    void editPrice(Long Id, double price);

}

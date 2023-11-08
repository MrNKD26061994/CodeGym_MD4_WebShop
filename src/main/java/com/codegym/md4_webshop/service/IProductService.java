package com.codegym.md4_webshop.service;

import com.codegym.md4_webshop.model.Product;
import com.codegym.md4_webshop.model.oderProduct.SearchOBJ;

public interface IProductService extends IGeneralService<Product> {
    void reduceQuantity(Long id, int quantity);

    void reducePrice(Long id, double price);

    Iterable<Product> searchByGender(String gender);

    Iterable<Product> searchProductByName(String name);

    Iterable<Product> filter(SearchOBJ searchOBJ);


}

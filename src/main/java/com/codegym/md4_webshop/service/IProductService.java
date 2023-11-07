package com.codegym.md4_webshop.service;

import com.codegym.md4_webshop.model.Product;
import com.codegym.md4_webshop.model.oderProduct.OrderProduct;
import com.codegym.md4_webshop.model.oderProduct.SearchOBJ;

import java.util.Optional;

public interface IProductService extends IGeneralService<Product> {
    boolean reduceQuantity(Long Id, int quantity);
    void reducePrice(Long Id, double price);
    Iterable<Product> searchByGender(String gender);

    Iterable<Product> searchProductByName(String name);

    Iterable<Product> filter(SearchOBJ searchOBJ);

    Iterable<OrderProduct> reportByYear(SearchOBJ searchOBJ);


}

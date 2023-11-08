package com.codegym.md4_webshop.service;


import com.codegym.md4_webshop.model.cart.Cart;
import com.codegym.md4_webshop.model.oderProduct.OrderProduct;
import com.codegym.md4_webshop.model.oderProduct.OrderProductID;

public interface IOrderProductService {
    void save(Cart item, Long idOrder);

    Iterable<OrderProduct> findAllByOrders(Long idOrders);

    void remove(OrderProductID id);
}

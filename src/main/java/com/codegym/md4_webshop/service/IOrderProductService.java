package com.codegym.md4_webshop.service;


import com.codegym.md4_webshop.model.cart.Cart;
import com.codegym.md4_webshop.model.oderProduct.OrderProduct;

public interface IOrderProductService {
    Cart save(Cart item, Long idOrder);

    Iterable<OrderProduct> findAllByOrders(Long idOrders);
}

package com.codegym.md4_webshop.controller;

import com.codegym.md4_webshop.model.cart.Cart;
import org.springframework.http.ResponseEntity;

public interface IGeneralController<T> {
    Iterable<Cart> list();

    ResponseEntity<Cart> create(T t);

    ResponseEntity<Cart> update(T t);

    ResponseEntity<Cart> delete();
}

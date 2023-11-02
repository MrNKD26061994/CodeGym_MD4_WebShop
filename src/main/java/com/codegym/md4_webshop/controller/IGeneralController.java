package com.codegym.md4_webshop.controller;

import com.codegym.md4_webshop.model.cart.Cart;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;

public interface IGeneralController<T> {
    ResponseEntity<Iterable<T>> list();

    ResponseEntity<T> create(T t);

    ResponseEntity<T> update(T t);

    ResponseEntity<T> delete(Long id);

    ResponseEntity<T> findById(Long id);
}

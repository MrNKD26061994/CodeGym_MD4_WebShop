package com.codegym.md4_webshop.service;

import com.codegym.md4_webshop.model.User;
import com.codegym.md4_webshop.model.cart.Cart;
import com.codegym.md4_webshop.model.cart.CartID;
import org.springframework.http.ResponseEntity;

import java.util.Optional;

public interface ICartService {

    Iterable<Cart> findAll(User user);

    Optional<Cart> findById(CartID id);

    Cart save(Cart cart, String action);

    void remove(CartID id);

}

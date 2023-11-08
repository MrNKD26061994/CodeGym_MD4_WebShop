package com.codegym.md4_webshop.service;

import com.codegym.md4_webshop.model.User;
import com.codegym.md4_webshop.model.cart.Cart;
import com.codegym.md4_webshop.model.cart.CartID;

import java.util.List;
import java.util.Optional;

public interface ICartService {

    Iterable<Cart> findAll(Long userID);

    Optional<Cart> findById(CartID id);

    void save(Cart cart);

    void plusOrSubProduct(Cart cart, String action);

    void remove(CartID id);

    Double total(List<Cart> cart);

    void toggleCheck(Long userID, Long productID);

    void toggleAllCheck(Long userID, boolean check);

    Boolean getStatusAllCheck(Long userID);

    void save(Long productID, Long userID, int quantity);

    Iterable<Cart> findAllByCheck(Long userID);
}

package com.codegym.md4_webshop.service.impl;

import com.codegym.md4_webshop.model.User;
import com.codegym.md4_webshop.model.cart.Cart;
import com.codegym.md4_webshop.model.cart.CartID;
import com.codegym.md4_webshop.repository.CartRepository;
import com.codegym.md4_webshop.service.ICartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CartService implements ICartService {

    @Autowired
    private CartRepository cartRepository;

    @Override
    public Iterable<Cart> findAll(User user) {
        return this.cartRepository.findAllByUser(user);
    }

    @Override
    public Optional<Cart> findById(CartID id) {
        return this.cartRepository.findById(id);
    }

    @Override
    public Cart save(Cart cart, String action) {
        Iterable<Cart> carts = cartRepository.findAllByUser(cart.getUser());
        for (Cart item : carts) {
            if(item.getProduct().getId().equals(cart.getProduct().getId())) {
                if (action.equals("add")) {
                    item.setCount(item.getCount() + 1);
                } else if(action.equals("sub")) {
                    item.setCount(item.getCount() - 1);
                    if(item.getCount() == 0) {
                        cartRepository.delete(item);
                        return item;
                    }
                } else {

                }
                return cartRepository.save(item);
            }
        }
        cart.setCount(1);
        cart.setId(new CartID(cart.getProduct().getId(), cart.getUser().getId()));
        return cartRepository.save(cart);
    }

    @Override
    public void remove(CartID id) {
        this.cartRepository.deleteById(id);
    }
}

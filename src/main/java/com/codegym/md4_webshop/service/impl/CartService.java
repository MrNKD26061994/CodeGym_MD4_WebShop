package com.codegym.md4_webshop.service.impl;

import com.codegym.md4_webshop.model.Product;
import com.codegym.md4_webshop.model.User;
import com.codegym.md4_webshop.model.cart.Cart;
import com.codegym.md4_webshop.model.cart.CartID;
import com.codegym.md4_webshop.repository.CartRepository;
import com.codegym.md4_webshop.service.ICartService;
import com.codegym.md4_webshop.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CartService implements ICartService {

    @Autowired
    private CartRepository cartRepository;

    @Autowired
    private IProductService productService;

    @Override
    public Iterable<Cart> findAll(Long userID) {
        User user = new User();
        user.setId(userID);
        return this.cartRepository.findAllByUser(user);
    }

    @Override
    public Optional<Cart> findById(CartID id) {
        return this.cartRepository.findById(id);
    }

    @Override
    public void save(Cart cart) {
        CartID cartID = new CartID(cart.getProduct().getId(), cart.getUser().getId());
        cart.setId(cartID);
        cartRepository.save(cart);
    }

    @Override
    public void plusOrSubProduct(Cart cart, String action) {
        Iterable<Cart> carts = cartRepository.findAllByUser(cart.getUser());
        for (Cart item : carts) {
            if (item.getProduct().getId().equals(cart.getProduct().getId())) {
                if (action.equals("add")) {
                    item.setCount(item.getCount() + 1);
                } else if (action.equals("sub")) {
                    item.setCount(item.getCount() - 1);
                    if (item.getCount() == 0) {
                        cartRepository.delete(item);
                        return;
                    }
                } else {

                }
                cartRepository.save(item);
                return;
            }
        }
        cart.setCount(1);
        cartRepository.save(cart);
    }

    @Override
    public void remove(CartID id) {
        this.cartRepository.deleteById(id);
    }

    @Override
    public Double total(List<Cart> cart) {
        double total = 0;
        for (Cart item : cart){
            Product product = productService.findById(item.getProduct().getId()).get();
            total += (product.getPrice() * (100+product.getDiscount())/100) * item.getCount();
        }
        return total;
    }

    @Override
    public void toggleCheck(Long userID, Long productID) {
        Cart cart = findById(new CartID(productID, userID)).get();
        if(cart.isChecked()){
            cart.setChecked(false);
        } else {
            cart.setChecked(true);
        }
        this.cartRepository.save(cart);
    }

    @Override
    public void toggleAllCheck(Long userID, boolean check) {
        Iterable<Cart> carts = findAll(userID);
        for (Cart item : carts) {
            item.setChecked(check);
            save(item);
        }
    }

    @Override
    public Boolean getStatusAllCheck(Long userID) {
        List<Cart> carts = (List<Cart>) findAll(userID);
        int count = 0;
        for (Cart item : carts) {
            if(item.isChecked()) {
                count += 1;
            }
        }
        return count == carts.size();
    }

    @Override
    public void save(Long productID, Long userID, int quantity) {
        Cart cart = findById(new CartID(productID, userID)).get();
        cart.setCount(quantity);
        cartRepository.save(cart);
    }

    @Override
    public Iterable<Cart> findAllByCheck(Long userID) {
        User user = new User();
        user.setId(userID);
        return this.cartRepository.findAllByUserAndChecked(user, true);
    }
}

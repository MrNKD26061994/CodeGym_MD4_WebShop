package com.codegym.md4_webshop.controller;

import com.codegym.md4_webshop.model.User;
import com.codegym.md4_webshop.model.cart.Cart;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin("*")
@RestController
@RequestMapping("/user")
public class UserController implements IGeneralController<User> {
    @Override
    public Iterable<User> list() {
        return null;
    }

    @Override
    public ResponseEntity<User> create(User user) {
        return null;
    }

    @Override
    public ResponseEntity<User> update(User user) {
        return null;
    }

    @Override
    public ResponseEntity<User> delete() {
        return null;
    }
}

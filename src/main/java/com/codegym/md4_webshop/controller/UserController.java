package com.codegym.md4_webshop.controller;

import com.codegym.md4_webshop.model.User;
import com.codegym.md4_webshop.model.cart.Cart;
import com.codegym.md4_webshop.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin("*")
@RestController
@RequestMapping("/user")
public class UserController implements IGeneralController<User> {
    @Autowired
    private IUserService userService;

    @Override
    public Iterable<User> list() {

        return this.userService.findAll();
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

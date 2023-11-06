package com.codegym.md4_webshop.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
<<<<<<< HEAD
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
=======
public class UserController{

>>>>>>> 2377016aca4b82acd0a4072540d3188c7163e8af
}
}

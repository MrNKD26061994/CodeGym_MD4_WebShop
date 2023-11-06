package com.codegym.md4_webshop.controller;


import com.codegym.md4_webshop.model.User;
import com.codegym.md4_webshop.model.cart.Cart;
import com.codegym.md4_webshop.model.cart.CartID;
import com.codegym.md4_webshop.service.ICartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@CrossOrigin("*")
@RestController
@RequestMapping("/cart")
public class   CartController {

    @Autowired
    private ICartService cartService;
    @GetMapping()
    public ResponseEntity<Iterable<Cart>> list(@RequestBody User user) {
        return new ResponseEntity<>(this.cartService.findAll(user), HttpStatus.OK);
    }
    @PostMapping()
    public ResponseEntity<Cart> create(@RequestBody Cart cart) {
        return new ResponseEntity<>(this.cartService.save(cart, "add"), HttpStatus.CREATED);
    }

    @PutMapping("/{action}")
    public ResponseEntity<Cart> update(@RequestBody Cart cart, @PathVariable String action) {
        return new ResponseEntity<>(this.cartService.save(cart, action), HttpStatus.CREATED);
    }
    @DeleteMapping()
    public ResponseEntity<Cart> delete(@RequestBody CartID id) {
        Optional<Cart> cart = cartService.findById(id);
        if(!cart.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        this.cartService.remove(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Cart> findById(@PathVariable CartID id){
        Optional<Cart> cart = this.cartService.findById(id);
        if(!cart.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<>(cart.get(), HttpStatus.OK);
        }
    }


}

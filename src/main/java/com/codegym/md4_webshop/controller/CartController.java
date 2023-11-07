package com.codegym.md4_webshop.controller;

import com.codegym.md4_webshop.model.User;
import com.codegym.md4_webshop.model.cart.Cart;
import com.codegym.md4_webshop.model.cart.CartID;
import com.codegym.md4_webshop.service.ICartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@CrossOrigin("*")
@RestController
@RequestMapping("/cart")
public class CartController {

    @Autowired
    private ICartService cartService;

    @GetMapping("/{userID}")
    public ResponseEntity<Iterable<Cart>> list(@PathVariable Long userID) {
        return new ResponseEntity<>(this.cartService.findAll(userID), HttpStatus.OK);
    }

    @GetMapping("/listCheck/{userID}")
    public ResponseEntity<Iterable<Cart>> listCheck(@PathVariable Long userID) {
        return new ResponseEntity<>(this.cartService.findAllByCheck(userID), HttpStatus.OK);
    }
    @GetMapping("/checkAll/{userID}")
    public ResponseEntity<Boolean> getStatusAllCheck(@PathVariable Long userID) {
        return new ResponseEntity<>(this.cartService.getStatusAllCheck(userID), HttpStatus.OK);
    }

    @GetMapping("/{userID}/{productID}")
    public ResponseEntity<Cart> findById(@PathVariable Long userID, @PathVariable Long productID) {
        CartID id = new CartID(productID, userID);
        Optional<Cart> cart = this.cartService.findById(id);
        if (!cart.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<>(cart.get(), HttpStatus.OK);
        }
    }

//    @GetMapping("/totalList")
//    public ResponseEntity<Double> total(@RequestBody List<Cart> cart) {
//        return new ResponseEntity<>(cartService.total(cart), HttpStatus.OK);
//    }

    @PostMapping()
    public ResponseEntity<Cart> create(@RequestBody Cart cart) {
        this.cartService.save(cart);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<Cart> update(@RequestBody Cart cart) {
        this.cartService.save(cart);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
    @PutMapping("/{productID}/{userID}/{quantity}")
    public ResponseEntity<Cart> updateQuantity(@PathVariable Long productID, @PathVariable Long userID, @PathVariable int quantity) {
        this.cartService.save(productID, userID, quantity);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
    @PutMapping("/{action}")
    public ResponseEntity<Cart> plusOrSubProduct(@RequestBody Cart cart, @PathVariable String action) {
        this.cartService.plusOrSubProduct(cart, action);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PutMapping("/{userID}/{productID}")
    public ResponseEntity<Cart> toggleCheck(@PathVariable Long userID, @PathVariable Long productID) {
        this.cartService.toggleCheck(userID, productID);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
    @PutMapping("/checkAll/{userID}/{check}")
    public ResponseEntity<Cart> toggleAllCheck(@PathVariable Long userID, @PathVariable boolean check) {
        this.cartService.toggleAllCheck(userID, check);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @DeleteMapping()
    public ResponseEntity<Cart> delete(@RequestBody CartID id) {
        Optional<Cart> cart = cartService.findById(id);
        if (!cart.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        this.cartService.remove(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }





}

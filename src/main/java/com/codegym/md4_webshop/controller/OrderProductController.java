package com.codegym.md4_webshop.controller;

import com.codegym.md4_webshop.dto.OrderProductDTO;
import com.codegym.md4_webshop.model.Orders;
import com.codegym.md4_webshop.model.cart.Cart;
import com.codegym.md4_webshop.model.oderProduct.OrderProduct;
import com.codegym.md4_webshop.service.ICartService;
import com.codegym.md4_webshop.service.IOrderProductService;
import com.fasterxml.jackson.databind.util.ArrayIterator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/order-product")
public class OrderProductController {

    @Autowired
    private IOrderProductService orderProductService;
    @GetMapping()
    public ResponseEntity<Iterable<OrderProduct>> list(@RequestBody Long idOrders) {
        return new ResponseEntity<>(this.orderProductService.findAllByOrders(idOrders), HttpStatus.OK);
    }
    @PostMapping()
    public ResponseEntity<Iterable<Cart>> create(@RequestBody OrderProductDTO orderProductDTO) {
        List<Cart> result = new ArrayList<>();
        for (Cart item: orderProductDTO.getCartList()) {
            result.add(this.orderProductService.save(item, orderProductDTO.getIdOrders()));
        }
        return new ResponseEntity<>(result, HttpStatus.CREATED);
    }

//    @PutMapping("/{action}")
//    public ResponseEntity<Cart> update(@RequestBody Cart cart, @PathVariable String action) {
//        return new ResponseEntity<>(this.cartService.save(cart, action), HttpStatus.CREATED);
//    }
//    @DeleteMapping()
//    public ResponseEntity<Cart> delete(@RequestBody CartID id) {
//        Optional<Cart> cart = cartService.findById(id);
//        if(!cart.isPresent()) {
//            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//        }
//        this.cartService.remove(id);
//        return new ResponseEntity<>(HttpStatus.OK);
//    }

//    @GetMapping("/{id}")
//    public ResponseEntity<Cart> findById(@PathVariable CartID id){
//        Optional<Cart> cart = this.cartService.findById(id);
//        if(!cart.isPresent()) {
//            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//        } else {
//            return new ResponseEntity<>(cart.get(), HttpStatus.OK);
//        }
//    }
}

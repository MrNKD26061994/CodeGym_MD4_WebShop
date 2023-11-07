package com.codegym.md4_webshop.controller;

import com.codegym.md4_webshop.dto.OrderProductDTO;
import com.codegym.md4_webshop.model.cart.Cart;
import com.codegym.md4_webshop.model.oderProduct.OrderProduct;
import com.codegym.md4_webshop.service.IOrderProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
        for (Cart item : orderProductDTO.getCartList()) {
            this.orderProductService.save(item, orderProductDTO.getIdOrders());
        }
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

}

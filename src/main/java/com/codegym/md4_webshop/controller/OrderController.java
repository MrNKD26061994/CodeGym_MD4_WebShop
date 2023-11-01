package com.codegym.md4_webshop.controller;

import com.codegym.md4_webshop.model.Image;
import com.codegym.md4_webshop.model.Orders;
import com.codegym.md4_webshop.service.IOrderService;
import org.hibernate.criterion.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin("*")
@RestController
@RequestMapping("/orders")
public class OrderController implements IGeneralController<Orders> {
private final IOrderService iOrderService;
@Autowired
    public OrderController(IOrderService iOrderService) {
        this.iOrderService = iOrderService;
    }

    @Override
    @GetMapping
    public ResponseEntity<Iterable<Orders>> list() {
        List<Orders> orders = (List<Orders>) iOrderService.findAll();
        if (orders.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(orders, HttpStatus.OK);
    }


    @Override
    @PostMapping
    public ResponseEntity<Orders> create(@RequestBody Orders orders) {
        Optional<Orders> optionalOrder = iOrderService.findById(orders.getId());
        if (optionalOrder.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(iOrderService.save(orders), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Orders> update(Orders orders) {
        return null;
    }

    @Override
    public ResponseEntity<Orders> delete(Orders orders) {
        return null;
    }
}

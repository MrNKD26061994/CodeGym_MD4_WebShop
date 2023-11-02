package com.codegym.md4_webshop.controller;

import com.codegym.md4_webshop.model.Orders;
import com.codegym.md4_webshop.service.IOrdersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin("*")
@RestController
@RequestMapping("/orders")
public class OrdersController implements IGeneralController<Orders> {

    @Autowired
    private IOrdersService ordersService;

    @Override
    public ResponseEntity<Iterable<Orders>> list() {
        return null;
    }

    @Override
    @PostMapping
    public ResponseEntity<Orders> create(@RequestBody Orders orders) {
        return new ResponseEntity<>(ordersService.save(orders), HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<Orders> update(Orders orders) {
        return null;
    }

    @Override
    public ResponseEntity<Orders> delete(Long id) {
        return null;
    }

    @Override
    @DeleteMapping
    public ResponseEntity<Orders> findById(@RequestBody Long id) {
        ordersService.remove(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}

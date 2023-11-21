package com.codegym.md4_webshop.controller;

import com.codegym.md4_webshop.dto.CustomerPayDTO;
import com.codegym.md4_webshop.model.Orders;
import com.codegym.md4_webshop.service.ICustomerService;
import com.codegym.md4_webshop.service.IOrdersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@CrossOrigin("*")
@RestController
@RequestMapping("/customer")
public class CustomerController {

    @Autowired
    private ICustomerService customerService;

    @Autowired
    private IOrdersService ordersService;

    @PostMapping
    public void pay(@RequestBody CustomerPayDTO customerPayDTO) {
        customerService.pay(customerPayDTO);
    }

    @DeleteMapping
    public ResponseEntity<Orders> cancel(@RequestBody Long id) {
        Optional<Orders> optionalOrders = ordersService.findById(id);
        if (!optionalOrders.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        customerService.cancel(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}

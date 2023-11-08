package com.codegym.md4_webshop.controller;

import com.codegym.md4_webshop.model.oderProduct.OrderProduct;
import com.codegym.md4_webshop.model.oderProduct.SearchOBJ;
import com.codegym.md4_webshop.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
@CrossOrigin("*")
@RestController
@RequestMapping("/api/reports")
public class ReportController {
    @Autowired
    private IProductService productService;
    @PostMapping("")
    public ResponseEntity<Iterable<OrderProduct>> reportByYear(@RequestBody SearchOBJ searchOBJ){
        Iterable<OrderProduct> orderProducts = productService.reportByYear(searchOBJ);
        return new ResponseEntity<>(orderProducts, HttpStatus.OK);
    }
    @PostMapping("/month")
    public ResponseEntity<Iterable<OrderProduct>> reportByMonth(@RequestBody SearchOBJ searchOBJ){
        Iterable<OrderProduct> orderProducts = productService.reportByMonth(searchOBJ);
        return new ResponseEntity<>(orderProducts, HttpStatus.OK);
    }
}

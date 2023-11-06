package com.codegym.md4_webshop.controller;

import com.codegym.md4_webshop.model.Product;
import com.codegym.md4_webshop.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/products")
public class ProductController {
    @Autowired
    private IProductService productService;

    @GetMapping("")
    public ResponseEntity<Iterable<Product>> showAll() {
        return new ResponseEntity<>(productService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Product>> findOne(@PathVariable ("id") Long id){
        Optional<Product> product = productService.findById(id);
        if(product.isPresent()){
            return new ResponseEntity<>(product,HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/create")
    public ResponseEntity<Product> createProduct(@RequestBody Product product){
        productService.save(product);
        return  new ResponseEntity<>(product, HttpStatus.CREATED);
    }

    @PostMapping("/update/{id}")
    public ResponseEntity<Product> updateProduct(@RequestBody Product product, @PathVariable ("id")Long id){
        Optional<Product> product1 = productService.findById(id);
        product.setId(product1.get().getId());
        productService.save(product);
        return new ResponseEntity<>(product, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProduct(@PathVariable ("id") Long id){
        productService.remove(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/men")
    public ResponseEntity<Iterable<Product>> searchMen() {
        return new ResponseEntity<>(productService.searchByGender("Nam"), HttpStatus.OK);
    }

    @GetMapping("/women")
    public ResponseEntity<Iterable<Product>> searchWomen() {
        return new ResponseEntity<>(productService.searchByGender("Nữ"), HttpStatus.OK);
    }
    @PostMapping("productRepository")
    public ResponseEntity<Iterable<Product>> searchProductByName(@RequestBody Product product) {
        return new ResponseEntity<>(productService.searchProductByName(product.getName()), HttpStatus.OK);
    }
}
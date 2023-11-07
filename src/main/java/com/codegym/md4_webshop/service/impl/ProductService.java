package com.codegym.md4_webshop.service.impl;

import com.codegym.md4_webshop.model.Product;
import com.codegym.md4_webshop.repository.ProductRepository;
import com.codegym.md4_webshop.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProductService implements IProductService {
    @Autowired
    private ProductRepository productRepository;

    @Override
    public Iterable<Product> findAll() {
        return productRepository.findAll();
    }

    @Override
    public Optional<Product> findById(Long id) {
        return productRepository.findById(id);
    }

    @Override
    public Product save(Product product) {
        return productRepository.save(product);
    }

    @Override
    public void remove(Long id) {
    productRepository.delete(productRepository.findById(id).get());
    }

    @Override
    public void reduceQuantity(Long id, int quantity) {
        Product product = productRepository.findById(id).get();
        product.setQuantity(product.getQuantity() - quantity);
        productRepository.save(product);
    }
    @Override
    public void reducePrice(Long id, double price) {
        Product product = productRepository.findById(id).get();
        product.setPrice(product.getPrice() - price);
        productRepository.save(product);
    }
}

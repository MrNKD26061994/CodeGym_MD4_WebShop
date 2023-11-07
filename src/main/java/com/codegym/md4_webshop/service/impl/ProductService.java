package com.codegym.md4_webshop.service.impl;

import com.codegym.md4_webshop.model.Product;
import com.codegym.md4_webshop.model.oderProduct.OrderProduct;
import com.codegym.md4_webshop.model.oderProduct.SearchOBJ;
import com.codegym.md4_webshop.repository.ProductRepository;
import com.codegym.md4_webshop.repository.ReportRepository;
import com.codegym.md4_webshop.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProductService implements IProductService {
    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private ReportRepository reportRepository;

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
    public boolean reduceQuantity(Long id, int quantity) {
        Optional<Product> product = productRepository.findById(id);
        if (product.isPresent()) {
            if (product.get().getQuantity() > quantity) {
                product.get().setQuantity(product.get().getQuantity() - quantity);
                productRepository.save(product.get());
                return true;
            } else {
                return false;
            }
        }
        return false;
    }

    @Override
    public void reducePrice(Long id, double price) {
        Optional<Product> product = productRepository.findById(id);
        product.get().setPrice(price);
        productRepository.save(product.get());
    }

    @Override
    public Iterable<Product> searchByGender(String gender) {
        Iterable<Product> productIterable = productRepository.searchByGender(gender);
        return productIterable;
    }

    @Override
    public Iterable<Product> searchProductByName(String name) {
        String newString = "%" + name + "%";
        return productRepository.search3(newString);
    }

    @Override
    public Iterable<Product> filter(SearchOBJ searchOBJ) {

        Long num1 = searchOBJ.getNum1();
        Long num2 = searchOBJ.getNum2();
        Long id = searchOBJ.getId();
        String name = searchOBJ.getName();
        String searchName = "%" + searchOBJ.getName() + "%";

        if (num1 != null && num2 != null && id != null & name != null) {
            return productRepository.search1and2and3(num1, num2, id, searchName);
        } else if (num1 != null && num2 != null && id != null & name == null) {
            return productRepository.search1and2(num1, num2, id);
        } else if (num1 != null && num2 != null && id == null & name != null) {
            return productRepository.search1and3(num1, num2, searchName);
        } else if (num1 != null && num2 != null && id == null & name == null) {
            return productRepository.Search1(num1, num2);
        } else if (num1 == null && num2 == null && id != null & name == null) {
            return productRepository.search2(id);
        } else if (num1 == null && num2 == null && id != null & name != null) {
            return productRepository.search2and3(id, searchName);
        } else {
            return productRepository.search3(searchName);
        }
    }

    @Override
    public Iterable<OrderProduct> reportByYear(SearchOBJ searchOBJ) {
        Iterable<OrderProduct> orderProducts = reportRepository.reportByYear(searchOBJ.getNum1());
        return orderProducts;
    }
}

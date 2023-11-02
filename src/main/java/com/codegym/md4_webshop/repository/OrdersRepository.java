package com.codegym.md4_webshop.repository;

import com.codegym.md4_webshop.model.Orders;
import com.codegym.md4_webshop.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrdersRepository extends JpaRepository<Orders, Long> {
}

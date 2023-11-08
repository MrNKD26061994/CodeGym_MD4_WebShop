package com.codegym.md4_webshop.repository;

import com.codegym.md4_webshop.model.oderProduct.OrderProduct;
import com.codegym.md4_webshop.model.oderProduct.OrderProductID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderProductRepository extends JpaRepository<OrderProduct, OrderProductID> {
    Iterable<OrderProduct> findByOrders_Id(Long idOrders);
}

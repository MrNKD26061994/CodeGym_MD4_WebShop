package com.codegym.md4_webshop.repository;

import com.codegym.md4_webshop.model.Product;
import com.codegym.md4_webshop.model.oderProduct.OrderProduct;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ReportRepository extends JpaRepository<OrderProduct, Long> {
    @Query(value = "select * from product_order join orders on product_order.order_id = orders.id having year(orders.time)= ?;", nativeQuery = true)
    Iterable<OrderProduct> reportByYear(@Param("num1") Long num1 );
}

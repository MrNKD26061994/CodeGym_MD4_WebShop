package com.codegym.md4_webshop.model.oderProduct;

import com.codegym.md4_webshop.model.Orders;
import com.codegym.md4_webshop.model.Product;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "product_order")
public class OrderProduct {
    @EmbeddedId
    private OrderProductID id;

    @ManyToOne
    @JoinColumn(name = "product_id")
    @MapsId("productID")
    private Product product;
    private int count;
    private double price;
    private int discount;
}

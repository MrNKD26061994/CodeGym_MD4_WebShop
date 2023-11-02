package com.codegym.md4_webshop.model.cart;

import com.codegym.md4_webshop.model.Product;
import com.codegym.md4_webshop.model.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "user_product")
public class Cart {

    @EmbeddedId
    private CartID id;

    @ManyToOne
    @JoinColumn(name = "product_id")
    @MapsId("productID")
    private Product product;

    @ManyToOne
    @JoinColumn(name = "user_id")
    @MapsId("userID")
    private User user;

    private int count;
}

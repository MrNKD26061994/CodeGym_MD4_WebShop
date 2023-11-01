package com.codegym.md4_webshop.model.cart;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Data
@Embeddable
@NoArgsConstructor
@AllArgsConstructor
public class CartID implements Serializable {
    private static final long serialVersionUID = 1L;

    @Column(name = "product_id")
    private Long productID;
    @Column(name = "user_id")
    private Long userID;
}

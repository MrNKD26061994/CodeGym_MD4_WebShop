package com.codegym.md4_webshop.dto;

import com.codegym.md4_webshop.model.cart.Cart;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderProductDTO {
    List<Cart> cartList;
    Long idOrders;
}

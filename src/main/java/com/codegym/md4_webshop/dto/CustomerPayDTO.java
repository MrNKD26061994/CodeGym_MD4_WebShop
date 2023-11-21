package com.codegym.md4_webshop.dto;

import com.codegym.md4_webshop.model.Pay;
import com.codegym.md4_webshop.model.User;
import com.codegym.md4_webshop.model.cart.Cart;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CustomerPayDTO {
    private Pay pay;
    private List<Cart> cartList;
    private String address;
    private User user;
}

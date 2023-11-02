package com.codegym.md4_webshop.service;

import com.codegym.md4_webshop.dto.CustomerPayDTO;
import com.codegym.md4_webshop.model.Orders;

public interface ICustomerService {
    void pay(CustomerPayDTO customerPayDTO);

    void cancel(Long idOrders);
}

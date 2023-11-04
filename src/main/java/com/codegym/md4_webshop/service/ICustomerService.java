package com.codegym.md4_webshop.service;

import com.codegym.md4_webshop.dto.CustomerPayDTO;

public interface ICustomerService {
    void pay(CustomerPayDTO customerPayDTO);

    void cancel(Long idOrders);
}

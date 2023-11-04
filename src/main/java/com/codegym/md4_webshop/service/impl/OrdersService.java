package com.codegym.md4_webshop.service.impl;

import com.codegym.md4_webshop.model.Orders;
import com.codegym.md4_webshop.repository.OrdersRepository;
import com.codegym.md4_webshop.service.IOrdersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class OrdersService implements IOrdersService {

    @Autowired
    private OrdersRepository ordersRepository;

    @Override
    public Iterable<Orders> findAll() {
        return null;
    }

    @Override
    public Optional<Orders> findById(Long id) {
        return Optional.empty();
    }

    @Override
    public Orders save(Orders orders) {
        orders.setTime(LocalDateTime.now());
        orders.setStatus(1);
        return this.ordersRepository.save(orders);
    }

    @Override
    public void remove(Long id) {
    }
}

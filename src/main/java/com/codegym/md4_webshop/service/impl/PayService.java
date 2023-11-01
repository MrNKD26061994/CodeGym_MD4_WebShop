package com.codegym.md4_webshop.service.impl;

import com.codegym.md4_webshop.model.Pay;
import com.codegym.md4_webshop.repository.PayRepository;
import com.codegym.md4_webshop.service.IPayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PayService implements IPayService {
    private final PayRepository payRepository;

    @Autowired
    public PayService(PayRepository payRepository) {
        this.payRepository = payRepository;
    }


    @Override
    public Iterable<Pay> findAll() {
        return payRepository.findAll();
    }

    @Override
    public Optional<Pay> findById(Long id) {
        return payRepository.findById(id);
    }

    @Override
    public Pay save(Pay pay) {
        return payRepository.save(pay);
    }

    @Override
    public void remove(Long id) {
        payRepository.deleteById(id);
    }

    @Override
    public Optional<Pay> findByName(String name) {
        return payRepository.findByName(name);
    }
}

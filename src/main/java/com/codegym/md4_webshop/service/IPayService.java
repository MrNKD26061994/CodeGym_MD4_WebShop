package com.codegym.md4_webshop.service;

import com.codegym.md4_webshop.model.Pay;

import java.util.Optional;

public interface IPayService extends IGeneralService<Pay>{
    Optional<Pay> findByName (String name);
}

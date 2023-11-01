package com.codegym.md4_webshop.service;

import com.codegym.md4_webshop.model.Pay;
import org.springframework.web.bind.annotation.RequestBody;

public interface IPayService extends IGeneralService<Pay>{
    Pay findPayByName (@RequestBody String name);
}

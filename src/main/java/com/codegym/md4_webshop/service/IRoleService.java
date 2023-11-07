package com.codegym.md4_webshop.service;

import com.codegym.md4_webshop.model.Role;

public interface IRoleService {
    void save(Role role);

    Iterable<Role> findAll();

    Role findByName(String name);

}

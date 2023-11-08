package com.codegym.md4_webshop.service;

import com.codegym.md4_webshop.model.ERole;
import com.codegym.md4_webshop.model.Role;

import java.util.Optional;

public interface IRoleService {
    void save(Role role);

    Iterable<Role> findAll();

    Role findByName(String name);

    Optional<Role> findByRoleName (ERole roleName);
}

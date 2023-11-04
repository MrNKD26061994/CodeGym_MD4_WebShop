package com.codegym.md4_webshop.service;

import com.codegym.md4_webshop.model.ERole;
import com.codegym.md4_webshop.model.Role;

import java.util.Optional;

public interface IRoleService {
    Optional<Role> findByRoleName (ERole roleName);

}

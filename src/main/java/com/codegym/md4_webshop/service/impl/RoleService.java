package com.codegym.md4_webshop.service.impl;

import com.codegym.md4_webshop.model.ERole;
import com.codegym.md4_webshop.model.Role;
import com.codegym.md4_webshop.repository.RoleRepository;
import com.codegym.md4_webshop.service.IRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public class RoleService implements IRoleService {
    private final RoleRepository roleRepository;
    @Autowired

    public RoleService(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    @Override
    public Optional<Role> findByRoleName(ERole roleName) {
        return roleRepository.findByRoleName(roleName);
    }
}

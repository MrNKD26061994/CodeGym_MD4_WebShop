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
    @Autowired
    private RoleRepository roleRepository;
    @Override
    public void save(Role role) {
        roleRepository.save(role);
    }

    @Override
    public Iterable<Role> findAll() {
        return roleRepository.findAll();
    }

    @Override
    public Role findByName(String name) {
        return null;
    }
    @Override
    public Optional<Role> findByRoleName(ERole roleName) {
        return roleRepository.findByRoleName(roleName);
    }
}

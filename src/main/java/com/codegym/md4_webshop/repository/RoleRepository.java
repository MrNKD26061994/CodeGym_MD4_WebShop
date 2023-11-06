package com.codegym.md4_webshop.repository;

import com.codegym.md4_webshop.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<Role , Long>{
    Role findByName(String roleName);
}

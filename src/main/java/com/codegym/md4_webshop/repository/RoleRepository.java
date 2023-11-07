package com.codegym.md4_webshop.repository;

import com.codegym.md4_webshop.model.ERole;
import com.codegym.md4_webshop.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
    Optional<Role> findByRoleName (ERole roleName);
}

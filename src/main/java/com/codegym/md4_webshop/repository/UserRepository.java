package com.codegym.md4_webshop.repository;

import com.codegym.md4_webshop.model.Role;
import com.codegym.md4_webshop.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);
    Iterable<User> findAllByStatus(int status);
    boolean existsByUsername (String email);

    Iterable<User> findAllByStatus(int status);
}

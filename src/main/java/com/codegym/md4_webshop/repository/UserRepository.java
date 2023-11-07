package com.codegym.md4_webshop.repository;

import com.codegym.md4_webshop.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    Iterable<User> findAllByStatus(int status);
}

package com.codegym.md4_webshop.repository;

import com.codegym.md4_webshop.model.Pay;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.Optional;

@Repository
public interface PayRepository extends JpaRepository<Pay, Long> {
    Optional<Pay> findByName (String name);
}

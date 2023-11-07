package com.codegym.md4_webshop.repository;

import com.codegym.md4_webshop.model.Company;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CompanyRepository extends JpaRepository<Company, Long> {
    Iterable<Company> findAllByStatus(int status);
}

package com.codegym.md4_webshop.repository;

import com.codegym.md4_webshop.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {
}

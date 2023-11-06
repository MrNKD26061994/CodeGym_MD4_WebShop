package com.codegym.md4_webshop.repository;

import com.codegym.md4_webshop.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    @Query(value = "select * from product where gender=?", nativeQuery = true)
    Iterable<Product> searchByGender(@Param("gender") String gender );

    @Query(value = "select * from product where name like ?", nativeQuery = true)
    Iterable<Product> searchByName(@Param("name") String name );

}

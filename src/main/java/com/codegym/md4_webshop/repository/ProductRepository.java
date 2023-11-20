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

//    1(Low & 2 Price), 2 (Category), 3(Name)

//    1
@Query(value = "select * from product where price between ? and ?;", nativeQuery = true)
Iterable<Product> Search1(@Param("num1") Long num1 ,
                               @Param("num2") Long num2);
//1,2
@Query(value = "select * from product where price between ? and ? and category_id=?;", nativeQuery = true)
Iterable<Product> search1and2(@Param("num1") Long num1 ,
                                @Param("num2") Long num2,
                              @Param("id")Long id);
//1,3
@Query(value = "select * from product where price between ? and ? and name like ?;", nativeQuery = true)
Iterable<Product> search1and3(@Param("num1") Long num1 ,
                              @Param("num2") Long num2,
                              @Param("name")String name);
//2
@Query(value = "select * from product where category_id=?;", nativeQuery = true)
Iterable<Product> search2(@Param("id") Long id);

//2,3
@Query(value = "select * from product where category_id=? and name like ?;", nativeQuery = true)
Iterable<Product> search2and3(@Param("id") Long id,
                              @Param("name")String name);
//    3
    @Query(value = "select * from product where name like ?", nativeQuery = true)
    Iterable<Product> search3(@Param("name") String name );

//    1,2,3
@Query(value = "select * from product where price between ? and ? and category_id=? and name like ?", nativeQuery = true)
Iterable<Product> search1and2and3(@Param("num1") Long num1 ,
                                  @Param("num2") Long num2,
                                  @Param("id") Long id,
                                  @Param("name")String name);
}

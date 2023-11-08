package com.codegym.md4_webshop.repository;

import com.codegym.md4_webshop.model.Image;
import com.codegym.md4_webshop.model.Pay;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ImageRepository extends JpaRepository<Image, Long> {
    Optional<Image> findImageByImage (String image);
}

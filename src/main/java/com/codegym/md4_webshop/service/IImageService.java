package com.codegym.md4_webshop.service;

import com.codegym.md4_webshop.model.Image;

import java.util.Optional;

public interface IImageService extends IGeneralService <Image> {
    Optional<Image> findImageByImage (String image);
}

package com.codegym.md4_webshop.controller;

import com.codegym.md4_webshop.model.Image;
import org.springframework.http.ResponseEntity;

public interface IGeneralController<T> {
 Iterable<T> list();
    ResponseEntity<Iterable<T>> list();
 //2377016aca4b82acd0a4072540d3188c7163e8af

    ResponseEntity<T> create(T t);

    ResponseEntity<T> update(T t);


    ResponseEntity<T> delete();
    ResponseEntity<T> delete(Long id);
    //  2377016aca4b82acd0a4072540d3188c7163e8af
}

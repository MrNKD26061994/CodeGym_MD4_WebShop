<<<<<<< HEAD
//package com.codegym.md4_webshop.controller;
//
//import com.codegym.md4_webshop.model.Image;
//import org.springframework.http.ResponseEntity;
//
//public interface IGeneralController<T> {
// Iterable<T> list();
//    ResponseEntity<Iterable<T>> list();
// //2377016aca4b82acd0a4072540d3188c7163e8af
//
//    ResponseEntity<T> create(T t);
//
//    ResponseEntity<T> update(T t);
//
//
//    ResponseEntity<T> delete();
//    ResponseEntity<T> delete(Long id);
//    //  2377016aca4b82acd0a4072540d3188c7163e8af
//}
=======
package com.codegym.md4_webshop.controller;

import com.codegym.md4_webshop.model.cart.Cart;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;

public interface IGeneralController<T> {
    ResponseEntity<Iterable<T>> list();

    ResponseEntity<T> create(T t);

    ResponseEntity<T> update(T t);

    ResponseEntity<T> delete(Long id);

    ResponseEntity<T> findById(Long id);
}
>>>>>>> 5484502c5ae5e679d4e1c218d70608a27bbd7adb

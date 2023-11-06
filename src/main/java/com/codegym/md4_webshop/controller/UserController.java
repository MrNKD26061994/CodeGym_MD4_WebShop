package com.codegym.md4_webshop.controller;

<<<<<<< HEAD
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
=======
import com.codegym.md4_webshop.model.User;
import com.codegym.md4_webshop.model.cart.Cart;
import com.codegym.md4_webshop.service.IRoleService;
import com.codegym.md4_webshop.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
>>>>>>> 51ffc333e05494a32fb8826e33147bb2f19c76c2

@RestController
@RequestMapping("/user")
<<<<<<< HEAD
public class UserController implements IGeneralController<User> {
<<<<<<< HEAD
    @Override
    public Iterable<User> list() {
        return null;
    }

    @Override
    public ResponseEntity<User> create(User user) {
        return null;
    }

    @Override
    public ResponseEntity<User> update(User user) {
        return null;
    }

    @Override
    public ResponseEntity<User> delete() {
        return null;
=======
    @Autowired
    private IUserService userService;
    @Autowired
    private IRoleService roleService;

    @GetMapping
    public ResponseEntity<Iterable<User>> list() {
        List<User> userList = (List<User>) userService.findAll();
        if (userList.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(userList, HttpStatus.OK);
    }

    @PostMapping("")
    public ResponseEntity<User> create(@RequestBody User user) {
        user.setStatus(1);
        userService.save(user);
        return new ResponseEntity<>(HttpStatus.CREATED);

    }

    @PutMapping("/{id}")
    public ResponseEntity<User> update(@RequestBody User user) {
        Optional<User> userOptional = userService.findById(user.getId());
        if (!userOptional.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        userService.save(user);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<User> delete(@PathVariable Long id) {
        Optional<User> userOptional = userService.findById(id);
        if (!userOptional.isPresent()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        userOptional.get().setStatus(0);
        userService.save(userOptional.get());
        return new ResponseEntity<>(HttpStatus.OK);
>>>>>>> 51ffc333e05494a32fb8826e33147bb2f19c76c2
    }
=======
public class UserController{

>>>>>>> 2377016aca4b82acd0a4072540d3188c7163e8af
}
}

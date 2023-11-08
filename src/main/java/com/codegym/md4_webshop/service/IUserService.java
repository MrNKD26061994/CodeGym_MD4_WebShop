package com.codegym.md4_webshop.service;


import com.codegym.md4_webshop.model.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.Optional;

public interface IUserService extends UserDetailsService {
    void save(User user);

    Iterable<User> findAll();

    Optional<User> findById(Long id);

    User getCurrentUser();

    UserDetails loadUserById(Long id);

    User findByUsername(String username);

    boolean checkLogin(User user);

    boolean isRegister(User user);

    boolean isCorrectConfirmPassword(User user);
    Iterable<User> findAllByStatus(int status);
    boolean existsByUsername (String email);
}

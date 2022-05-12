package com.example.springsecurityv2.service;


import com.example.springsecurityv2.modal.User;

import java.util.Optional;

public interface UserService {

    void saveUser(User user);
    Optional<User> findUserByUsername(String email);
    Boolean existsByEmail(String email);
    Boolean existsByUsername(String username);
    User findByID(Long id);

}

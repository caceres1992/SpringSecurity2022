package com.example.springsecurityv2.service;

import com.example.springsecurityv2.modal.User;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

@Service
@Transactional
public class UserServiceImpl implements UserService {
    @Override
    public void saveUser(User user) {

    }

    @Override
    public Optional<User> findUserByUsername(String email) {
        return Optional.empty();
    }


    @Override
    public Boolean existsByEmail(String email) {
        return null;
    }

    @Override
    public Boolean existsByUsername(String username) {
        return null;
    }

    @Override
    public User findByID(Long id) {
        return null;
    }
}

package com.example.ocgBackend.service;

import com.example.ocgBackend.persistence.model.User;
import com.example.ocgBackend.persistence.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<User> getAllUsers() {
        return userRepository.findAll().stream().toList();
    }
}

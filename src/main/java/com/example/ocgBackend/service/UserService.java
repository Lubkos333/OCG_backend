package com.example.ocgBackend.service;

import com.example.ocgBackend.persistence.repositories.UserRepository;
import com.example.ocgBackend.rest.api.dto.UserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public ResponseEntity getAllUsers() {
        return ResponseEntity.ok(
                userRepository.findAll()
                .stream()
                .map(user -> new UserDto().name(user.getName())).toArray()
                );
    }
}

package com.example.ocgBackend.rest;

import com.example.ocgBackend.persistence.model.User;
import com.example.ocgBackend.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping(path = "all")
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }
}

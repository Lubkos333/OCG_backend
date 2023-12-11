package com.example.ocgBackend.rest;

import com.example.ocgBackend.rest.api.UserApi;
import com.example.ocgBackend.rest.api.UserApiDelegate;
import com.example.ocgBackend.rest.api.dto.UserDto;
import com.example.ocgBackend.rest.api.dto.Users;
import com.example.ocgBackend.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.NativeWebRequest;

import java.math.BigDecimal;
import java.util.Optional;

@Component
public class UserController implements UserApi, UserApiDelegate {

    @Autowired
    private UserService userService;

    @Override
    public ResponseEntity<Users> getUserPreferences() {
        return userService.getAllUsers();
    }

    @Override
    public ResponseEntity<UserDto> signUser(String userName) {
        return userService.onetimeLogin(userName);
    }

    @Override
    public ResponseEntity<UserDto> getUserById(BigDecimal userId) {
        return userService.getUserById(userId.longValue());
    }

    @Override
    public ResponseEntity<Void> testOperation(String body) {
        System.out.println(body);
        return ResponseEntity.ok(null);
    }

    @Override
    public UserApiDelegate getDelegate() {
        return UserApi.super.getDelegate();
    }

    @Override
    public Optional<NativeWebRequest> getRequest() {
        return UserApiDelegate.super.getRequest();
    }

}

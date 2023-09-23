package com.app.task.management.controller;

import com.app.task.management.model.User;
import com.app.task.management.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;
import java.util.Objects;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/auth")
public class UserController {
    private final UserService userService;

    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody User user){
        Map<String, Object> response =  userService.register(user);

        if (response.containsKey("status"))
            return new ResponseEntity<>(response, HttpStatus.CREATED);

        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }
}

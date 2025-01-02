package com.treeleef.leef.controllers;

import com.treeleef.leef.dto.CreateUserDto;
import com.treeleef.leef.models.User;
import com.treeleef.leef.services.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/users")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {this.userService = userService;}

    @PostMapping
    public ResponseEntity<User> createOrder(@RequestBody CreateUserDto createUserDto) {
        var result = userService.createUser(createUserDto);
        return result.map(user -> new ResponseEntity<>(user, HttpStatus.OK)).orElseGet(() -> new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR));
    }
}

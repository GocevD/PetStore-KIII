package com.gocevd.petstore.web;

import com.gocevd.petstore.model.User;
import com.gocevd.petstore.service.UserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/list-users")
    public List<User> listUsers() {
        return userService.listUsers();
    }

    @PostMapping("/create-users")
    public void createUsers() {
        userService.createUsers();
    }

}


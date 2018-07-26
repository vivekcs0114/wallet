package com.synerzip.wallet.controller;

import com.synerzip.wallet.model.User;
import com.synerzip.wallet.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping
    public User create(@Valid @RequestBody User user) {
        return userService.create(user);
    }

    @GetMapping("/{id}")
    public User find(@PathVariable("id") int id) {
        return userService.find(id);
    }
}

package com.demo.spring_security_telusko.controller;

import com.demo.spring_security_telusko.entity.Users;
import com.demo.spring_security_telusko.service.UsersService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UserController {

    private UsersService usersService;

    public UserController(UsersService usersService) {
        this.usersService = usersService;
    }

    @PostMapping("/register")
    public Users register(@RequestBody Users user) {
        return usersService.register(user);
    }

}

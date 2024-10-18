package com.demo.spring_security_telusko.controller;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @GetMapping("/")
    public String home(HttpServletRequest request) {
        return "Hello World" + "\n" + request.getSession().getId();
    }

}

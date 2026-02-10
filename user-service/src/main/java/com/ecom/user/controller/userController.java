package com.ecom.user.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class userController {

    @GetMapping("/hello")
    public String helloUser() {
        return "Hello from User Service";
    }
}

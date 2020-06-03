package com.example.springexxample.controller;

import com.example.springexxample.domain.User;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(value = "api/login", consumes = "application.api")
public class LoginRestController {

    @PostMapping
    public void login(@RequestBody User user) {

    }
}

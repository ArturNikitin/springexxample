package com.example.springexxample.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TestUserController {
    @GetMapping("/user")
    public String forUser(){
        return "forUser";
    }
}

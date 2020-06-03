package com.example.springexxample.controller;

import com.example.springexxample.domain.User;
import lombok.Data;
import org.springframework.security.crypto.password.PasswordEncoder;

@Data
public class RegistrationForm {
    private String login;
    private String password;

    public RegistrationForm(String login, String password) {
        this.login = login;
        this.password = password;
    }

    public User toUser(PasswordEncoder passwordEncoder) {
        return new User(login,
                passwordEncoder.encode(password));
    }
}

package com.example.springexxample.service;

import com.example.springexxample.domain.User;
import com.example.springexxample.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserRepositoryUsersDetailsService implements UserDetailsService {
    @Autowired
    private UserRepository userRepo;

    @Override
    public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
        User user = userRepo.findUserByLogin(login);
        if (user != null) {
            return user;
        }
        throw new UsernameNotFoundException("User " + login + " no found");
    }
}

package com.example.springexxample.repository;

import com.example.springexxample.domain.User;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface UserRepository extends CrudRepository<User, Long> {
    User findUserById(Long id);
    User findUserByLogin(String login);
    List<User> findAll();
}

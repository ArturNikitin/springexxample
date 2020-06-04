package com.example.springexxample.controller;

import com.example.springexxample.domain.User;
import com.example.springexxample.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/api", produces = "application/json")
@CrossOrigin(origins = "*")
public class LoginController {

    @Autowired
    private UserRepository userRepo;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @GetMapping(value = "/all", produces = "application/json")
    public Iterable<User> allUsers(){
        return userRepo.findAll();
    }

    @GetMapping("/{id}")
    public User userByID(@PathVariable("id") Long id) {
        return userRepo.findUserById(id);
    }

    @PostMapping
    public void addUser(@RequestParam(value = "login", required = true) String login,
                        @RequestParam(value = "password", required = true) String password) {
        userRepo.save(new User(login, password));
    }

    @PostMapping(value = "/add", consumes = "application/json")
    @ResponseStatus(HttpStatus.CREATED)
    public void addUser(@RequestBody(required = true) User user) {
        userRepo.save(user);
    }

    @PostMapping(value = "/create", consumes = "application/json")
    @ResponseStatus(HttpStatus.CREATED)
    public void processApiRegistration(@RequestBody(required = true) User user) {
        RegistrationForm form = new RegistrationForm(user.getLogin(), user.getPassword());
        userRepo.save(form.toUser(passwordEncoder));
    }

    /*@PostMapping(value = "/login", consumes = "application/json")
    @ResponseStatus(HttpStatus.OK)
    public void processApiLogin(@RequestBody(required = true) User user) {
        RegistrationForm form = new RegistrationForm(user.getLogin(), user.getPassword());
        userRepo.save(form.toUser(passwordEncoder));
    }*/
}

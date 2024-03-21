package ru.geekbrains.SeminarRest.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.geekbrains.SeminarRest.domain.User;
import ru.geekbrains.SeminarRest.services.RegistrationService;
import ru.geekbrains.SeminarRest.services.UserService;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private RegistrationService registrationService;

    @Autowired
    private UserService userService;

    @PostMapping()
    public ResponseEntity<Object> createUser(@RequestBody User user) {
        try {
            return new ResponseEntity<>(registrationService.processRegistration(user),
                    HttpStatus.CREATED);
        } catch (IllegalArgumentException e) {
            return new ResponseEntity<>(e.getMessage(),
                    HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    @PostMapping("/create")
    public ResponseEntity<Object> userAddFromParam(@RequestParam("name") String name, @RequestParam("age") int age, @RequestParam("email") String email) {
        try {
            User user = new User(name, age, email);
            return new ResponseEntity<>(registrationService.processRegistration(user),
                    HttpStatus.CREATED);
        } catch (IllegalArgumentException e) {
            return new ResponseEntity<>(e.getMessage(),
                    HttpStatus.BAD_REQUEST);
        }
    }

}

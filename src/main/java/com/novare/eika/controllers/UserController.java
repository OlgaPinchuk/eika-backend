package com.novare.eika.controllers;

import com.novare.eika.models.User;
import com.novare.eika.models.UserInput;
import com.novare.eika.services.UserService;
import com.novare.eika.utils.PasswordHasher;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.security.NoSuchAlgorithmException;
import java.util.List;
import java.util.Map;


@RestController
@RequestMapping("login")
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping
    public List<User> getUsers() {
        return userService.getAll();
    }

    @GetMapping("/{id}")
    User getUser(@PathVariable long id) {
        return userService.get(id);
    }

    @PostMapping
    ResponseEntity<?> registerUser(@RequestBody UserInput userInput) throws NoSuchAlgorithmException {
        User existingUser = userService.findByEmail(userInput.getEmail());

        if (existingUser != null) {
            String enteredPasswordHash = PasswordHasher.hashPassword(userInput.getPassword());

            if (enteredPasswordHash.equals(existingUser.getPassword())) {
                return ResponseEntity.ok(createResponse(existingUser.getId()));
            } else {
                return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid credentials");
            }
        }
        else {
            User newUser = new User();
            newUser.setEmail(userInput.getEmail());
            String hashedPassword = PasswordHasher.hashPassword(userInput.getPassword());
            newUser.setPassword(hashedPassword);

            User createdUser = userService.create(newUser);

            return ResponseEntity.ok(createResponse(createdUser.getId()));
        }
    }

    private Map<String, Long> createResponse(long userId) {
        return Map.of("userId", userId);
    }

}

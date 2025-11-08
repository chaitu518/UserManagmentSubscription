package com.srt.usermanagementsubscription.controller;

import com.srt.usermanagementsubscription.Exceptions.CustomExceptions.UserNotFoundException;
import com.srt.usermanagementsubscription.model.User;
import com.srt.usermanagementsubscription.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping
@RestController
public class UserController {
    private final UserService userService;
    public UserController(UserService userService) {

        this.userService = userService;
    }
    @PostMapping("/users")
    public ResponseEntity<User> createUser(@RequestBody User user) {
        User userCreated = userService.addUser(user);
        return ResponseEntity.ok(userCreated);
    }
    @GetMapping("/users")
    public ResponseEntity<List<User>> getAllUsers() {
        return ResponseEntity.ok(userService.findUsers());
    }
    @GetMapping("/users/{id}")
    public ResponseEntity<User> getUser(@PathVariable long id) {
        User user =  userService.findUserById(id);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }
    @PutMapping("/users")
    public ResponseEntity<User> updateUser(@RequestBody User user) {
        return ResponseEntity.ok(userService.updateUser(user));

    }
    @DeleteMapping("/users/{id}")
    public ResponseEntity<?> deleteUser(@PathVariable long id) {
            userService.deleteUser(id);
            return ResponseEntity.noContent().build();
    }

}

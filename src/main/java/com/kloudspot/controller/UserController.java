package com.kloudspot.controller;

import java.util.List;

import com.kloudspot.models.User;
import com.kloudspot.service.UserService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/user-api")
@CrossOrigin(origins = "http://localhost:4200")
public class UserController {

    private UserService userService;
    private static Logger LOGGER = LoggerFactory.getLogger(UserController.class);

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("")
    public ResponseEntity<String> userHome(HttpServletRequest httpServletRequest) {
        String username = (String)httpServletRequest.getAttribute("username");

        return ResponseEntity.ok("Welcome to user-api " + username);
    }

    @GetMapping("/users")
    public ResponseEntity<List<User>> getAllUsers() {
        List<User> users = userService.getAll();
        return ResponseEntity.ok(users);
    }

    @GetMapping("/users/{id}")
    public ResponseEntity<User> getById(@PathVariable("id") int id) {
        User user = userService.getById(id);

        return ResponseEntity.ok(user);
    }

    @GetMapping("/users/firstname/{name}")
    public ResponseEntity<List<User>> getByFirstName(@PathVariable("name") String name) {
        List<User> users = userService.getByFirstName(name);
        return ResponseEntity.ok(users);
    }

    @GetMapping("/users/lastname/{name}")
    public ResponseEntity<List<User>> getByLastName(@PathVariable("name") String name) {
        List<User> users = userService.getByLastName(name);
        return ResponseEntity.ok(users);
    }

    @GetMapping("/users/city/{city}")
    public ResponseEntity<List<User>> getByCity(@PathVariable("city") String city) {
        List<User> users = userService.getByCity(city);
        return ResponseEntity.ok(users);
    }

    @GetMapping("/users/state/{state}")
    public ResponseEntity<List<User>> getByState(@PathVariable("state") String state) {
        List<User> users = userService.getByState(state);
        return ResponseEntity.ok(users);
    }

    @GetMapping("/users/pincode/{pincode}")
    public ResponseEntity<List<User>> getByPincode(@PathVariable("pincode") String pincode) {
        List<User> users = userService.getByPincode(pincode);
        return ResponseEntity.ok(users);
    }

    @PostMapping("/users")
    public ResponseEntity<User> createNewUser(@RequestBody User user) {
        User createdUser = userService.addUser(user);
        return ResponseEntity.ok(createdUser);
    }

    @PutMapping("/users")
    public ResponseEntity<User> updateUser(@RequestBody User user) {
        User updatedUser = userService.updateUser(user);
        return ResponseEntity.ok(updatedUser);
    }

    @DeleteMapping("/users/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable("id") int id) {
        userService.deleteUser(id);

        return ResponseEntity.ok(null);
    }
}

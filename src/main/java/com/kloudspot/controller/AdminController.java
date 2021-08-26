package com.kloudspot.controller;

import com.kloudspot.models.User;
import com.kloudspot.repository.UserRepository;
import com.kloudspot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/admin-api")
public class AdminController {

    @Autowired
    UserService userService;

    @GetMapping("")
    public ResponseEntity<?> adminApiHome() {
        return ResponseEntity.ok("Welcome to admin-api.");
    }

    @DeleteMapping("/user/{id}")
    public ResponseEntity<?> deleteUser(@PathVariable("id") int id) {
        userService.deleteUser(id);

        return ResponseEntity.ok("User deleted.");
    }

    @PatchMapping("/give-admin/{id}")
    public ResponseEntity<?> giveUserAdminRole(@PathVariable("id") int id) {
        User user = userService.getById(id);

        List<String> roles = user.getRoles();
        if (!roles.contains("ROLE_ADMIN")) {
            roles.add("ROLE_ADMIN");
        }
        user.setRoles(roles);
        userService.updateUser(user);

        return ResponseEntity.ok("User now has admin privileges");
    }

    @PatchMapping("/remove-admin/{id}")
    public ResponseEntity<?> removeUserAdminRole(@PathVariable("id") int id) {
        User user = userService.getById(id);

        List<String> roles = user.getRoles();
        roles.removeIf((String role) -> role.equals("ROLE_ADMIN"));
        user.setRoles(roles);
        userService.updateUser(user);

        return ResponseEntity.ok("User no longer has admin privileges");
    }
}

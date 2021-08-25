package com.kloudspot.controller;

import com.kloudspot.models.LoginDTO;
import com.kloudspot.models.RegistrationDTO;
import com.kloudspot.models.User;
import com.kloudspot.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;

@RestController()
@RequestMapping("/auth-api")
public class AuthenticationController {

    private static Logger LOGGER = LoggerFactory.getLogger(AuthenticationController.class);

    @Autowired
    UserService userService;

    @Autowired
    PasswordEncoder passwordEncoder;

    @Autowired
    AuthenticationManager authenticationManager;

    @GetMapping("")
    public ResponseEntity<String> home() {
        return ResponseEntity.ok("Welcome to auth-api.");
    }

    @GetMapping("/home")
    public ResponseEntity<String> home2() {
        return ResponseEntity.ok("Welcome to auth-api.");
    }

    @PostMapping("/register")
    public ResponseEntity<User> register(@RequestBody RegistrationDTO registrationDTO) {
        LOGGER.info(registrationDTO.toString());

        String encodedPassword = passwordEncoder.encode(registrationDTO.getPassword());

        User user = new User(-1, registrationDTO.getFirstname(), registrationDTO.getLastname(), registrationDTO.getEmailId(), encodedPassword, registrationDTO.getAddress(), Arrays.asList("USER"));

        user = userService.addUser(user);

        return ResponseEntity.ok(user);
    }

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody LoginDTO loginDTO) {
        LOGGER.info(loginDTO.toString());

        String encodedPassword = passwordEncoder.encode(loginDTO.getPassword());

        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
                loginDTO.getEmailId(), loginDTO.getPassword()
        ));

        LOGGER.info("Authenticated");
        return ResponseEntity.ok("Welcome");
    }
}

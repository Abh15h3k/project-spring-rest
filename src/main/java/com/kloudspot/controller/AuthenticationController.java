package com.kloudspot.controller;

import com.kloudspot.configuration.JwtUtil;
import com.kloudspot.configuration.MyUserDetailsService;
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
import org.springframework.security.core.userdetails.UserDetails;
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

    @Autowired
    MyUserDetailsService myUserDetailsService;

    @Autowired
    JwtUtil jwtUtil;

    @GetMapping("")
    public ResponseEntity<String> home() {
        return ResponseEntity.ok("Welcome to auth-api.");
    }

    @PostMapping("/register")
    public ResponseEntity<User> register(@RequestBody RegistrationDTO registrationDTO) {

        String encodedPassword = passwordEncoder.encode(registrationDTO.getPassword());
        User user = new User(-1, registrationDTO.getFirstname(), registrationDTO.getLastname(), registrationDTO.getEmailId(), encodedPassword, registrationDTO.getAddress(), Arrays.asList("ROLE_USER"));
        user = userService.addUser(user);

        return ResponseEntity.ok(user);
    }

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody LoginDTO loginDTO) {

        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
                loginDTO.getEmailId(), loginDTO.getPassword()
        ));

        UserDetails userDetails = myUserDetailsService.loadUserByUsername(loginDTO.getEmailId());

        String jwt = jwtUtil.generateToken(userDetails);

        return ResponseEntity.ok(jwt);
    }
}

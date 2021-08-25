package com.kloudspot.controller;

import org.springframework.context.annotation.Profile;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController()
@RequestMapping("/auth-api")
public class AuthenticationController {
    @GetMapping("")
    @Profile("!prod")
    public ResponseEntity<String> home() {
        return ResponseEntity.ok("Welcome to auth-api.");
    }


}

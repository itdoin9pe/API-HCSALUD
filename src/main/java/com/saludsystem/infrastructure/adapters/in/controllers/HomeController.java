package com.saludsystem.infrastructure.adapters.in.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
public class HomeController {

    @GetMapping("/")
    public String done() {
        return "Done API SYSSALUD";
    }

    @GetMapping("/actuator-check")
    public ResponseEntity<String> check() {
        return ResponseEntity.ok("Running");
    }
}
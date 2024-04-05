package com.example.javaspringdemo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class HelloController {

    @GetMapping
    public List<String> hello() {
        return List.of("Hello there!", "Welcome to the app.");
    }
}

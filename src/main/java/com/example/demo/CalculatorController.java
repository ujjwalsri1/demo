package com.example.demo;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/")
@CrossOrigin(origins = "http://localhost:3000")
public class CalculatorController {

    @GetMapping("/add")
    public double add(@RequestParam double a, @RequestParam double b) {
        return a + b;
    }

    

    @GetMapping("/subtract")
    public double subtract(@RequestParam double a, @RequestParam double b) {
        return a - b;
    }

    @GetMapping("/multiply")
    public double multiply(@RequestParam double a, @RequestParam double b) {
        return a * b;
    }

    @GetMapping("/divide")
    public double divide(@RequestParam double a, @RequestParam double b) {
        if (b == 0) throw new IllegalArgumentException("Division by zero is not allowed.");
        return a / b;
    }
}

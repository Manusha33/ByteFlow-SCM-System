package com.byteflow.inventory.controller;

import lombok.Data;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController // This tells Spring this class handles web requests
@Data // Lombok annotation to generate getters/setters automatically
public class TestController {

    private String status = "Annotations are working!";

    @GetMapping("/test") // This creates a URL at http://localhost:8080/test
    public String checkStatus() {
        return "The SCM Inventory system is running!";
    }
}



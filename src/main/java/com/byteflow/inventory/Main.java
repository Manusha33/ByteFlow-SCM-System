package com.byteflow.inventory;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication // This is the "on" switch for Spring Boot
public class Main {

    public static void main(String[] args) {
        // This line launches the Tomcat server and your Controller
        SpringApplication.run(Main.class, args);
    }
}
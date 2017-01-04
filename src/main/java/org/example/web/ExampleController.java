package org.example.web;


import org.springframework.boot.*;
import org.springframework.boot.autoconfigure.*;
import org.springframework.stereotype.*;
import org.springframework.web.bind.annotation.*;

/**
 * Simple Spring Boot powered application for Jenkins Pipeline example.
 */
@Controller
@EnableAutoConfiguration
public class ExampleController {

    @RequestMapping("/")
    @ResponseBody
    String root() {
        return "Hello Jenkins!";
    }

    public static void main(String[] args) throws Exception {
        SpringApplication.run(ExampleController.class, args);
    }
}

package com.example.springnext.controller;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;



@RestController


public class MyRestController {
    @GetMapping("/hello")
    public String sayHello() {
        return "Hej, världen!";
    }


}


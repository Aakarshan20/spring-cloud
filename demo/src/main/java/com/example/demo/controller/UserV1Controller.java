package com.example.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RequestMapping("api/user")
@RestController
public class UserV1Controller {
    @GetMapping("/test")
    public String test(){
        return "version1";
    }    

    @GetMapping("/extend")
    public String extendTest() {
        return "user v1 extend";
    }
    
}


package com.example.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.version.ApiVersion;


@RequestMapping("api/user")
@RestController
@ApiVersion(2)
public class UserV2Controller {
    @GetMapping("/test")
    public String test(){
        return "user v2 test";
    }        
}


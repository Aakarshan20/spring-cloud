package com.example.demo.controller;

import com.example.demo.model.Mysql;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;


@RestController
public class HelloController {
  @Value("${server.port}")
  String port;

  @Autowired
  Mysql mysql;

  @RequestMapping("/hello")
  public String home(String name) {

    System.out.println(mysql.getUser());
    System.out.println(mysql.getPassword());

    return "hi " + name + ", i am from port:" + port;
  }
}
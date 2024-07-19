package com.example.demo.controller;

import com.example.demo.model.Mysql;

import java.io.PrintWriter;

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

    System.out.println(mysql.getUserName());
    System.out.println(mysql.getPassword());


    PrintWriter writer = null;

    //writer.close();
    return "hi " + name + ", i am from port:" + port + ", username:" + mysql.getUserName() + ", password: " + mysql.getPassword();
  }
}
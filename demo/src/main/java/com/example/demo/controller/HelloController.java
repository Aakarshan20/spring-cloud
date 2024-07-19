package com.example.demo.controller;

import com.example.demo.auth.AuthorizeIn;
import com.example.demo.model.Mysql;

import java.io.PrintWriter;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.util.Assert;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import javax.validation.Valid;


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

    writer.close(); // 故意引發錯誤
    return "hi " + name + ", i am from port:" + port + ", username:" + mysql.getUserName() + ", password: " + mysql.getPassword();
  }

  @GetMapping("authorize")
  public void authorize(@Valid AuthorizeIn authorize, BindingResult result) {

    if(result.hasFieldErrors()){
      List<FieldError> errorList = result.getFieldErrors();
      errorList.stream().forEach(item->Assert.isTrue(false, item.getDefaultMessage()));
    }
  }


}
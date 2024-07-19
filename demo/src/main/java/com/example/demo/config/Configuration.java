package com.example.demo.config;

import com.example.demo.model.Mysql;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.context.annotation.Bean;

@SpringBootConfiguration
public class Configuration {
    @Value("${spring.datasource.username}")
    private String username;

    @Value("${spring.datasource.password}")
    private String password;

    @Bean
    public Mysql mysql(){
        Mysql mysql = new Mysql();
        mysql.setUserName(username);
        mysql.setPassword(password);
        return mysql;
    }
}

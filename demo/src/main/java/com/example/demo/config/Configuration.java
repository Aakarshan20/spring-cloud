package com.example.demo.config;

import com.example.demo.model.Mysql;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.context.annotation.Bean;

@SpringBootConfiguration
public class Configuration {
    @Value("${mysql_user}")
    private String mysqlUser;

    @Value("${mysql_password}")
    private String mysqlPassword;

    @Bean
    public Mysql mysql(){
        Mysql mysql = new Mysql();
        mysql.setUser(mysqlUser);
        mysql.setPassword(mysqlPassword);
        return mysql;
    }
}

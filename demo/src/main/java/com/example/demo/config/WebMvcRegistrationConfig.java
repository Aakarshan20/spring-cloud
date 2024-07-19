package com.example.demo.config;

import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.autoconfigure.web.servlet.WebMvcRegistrations;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;

import com.example.demo.handler.mapping.ApiRequestMappingHandlerMapping;

//@SpringBootConfiguration
public class WebMvcRegistrationConfig implements WebMvcRegistrations{
    @Override
    public RequestMappingHandlerMapping getRequestMappingHandlerMapping(){
        return new ApiRequestMappingHandlerMapping();
    }
}

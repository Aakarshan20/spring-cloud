package com.example.demo.config;

import com.example.demo.interceptor.ApiInterceptor;

import org.springframework.boot.SpringBootConfiguration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

@SpringBootConfiguration
public class WebConfig extends WebMvcConfigurationSupport {
    
    @Override
    protected void addInterceptors(InterceptorRegistry registry) {
        super.addInterceptors(registry); // 註冊api截斷類
        registry.addInterceptor(new ApiInterceptor());
    }


}

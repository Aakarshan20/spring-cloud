package com.example.demo.config;

import com.example.demo.interceptor.ApiInterceptor;
import com.example.demo.version.ApiRequestMappingHandlerMapping;

import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.autoconfigure.web.servlet.WebMvcRegistrations;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;

//@SpringBootConfiguration
// 一但 springbootconfiguration 中有 WebMvcConfigurationSupport, 他就會忽略 WebMvcRegistrations 導致啟動失敗
// todo 找解決方法
// public class WebConfig extends WebMvcConfigurationSupport 
public class WebConfig { 
    
    // @Override
    // protected void addInterceptors(InterceptorRegistry registry) {
    //     super.addInterceptors(registry); // 註冊api截斷類
    //     System.out.println("22222222222222222222");
    //     registry.addInterceptor(new ApiInterceptor());
    // }

    

}

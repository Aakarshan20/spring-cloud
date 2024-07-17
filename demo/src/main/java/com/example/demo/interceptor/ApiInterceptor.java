package com.example.demo.interceptor;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

public class ApiInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest httpServiceRequest, HttpServletResponse httpServiceResponse, Object o) throws Exception{
        System.out.println("開始攔截");
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest httpServiceRequest, HttpServletResponse httpServiceResponse, Object o, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest httpServiceRequest, HttpServletResponse httpServiceResponse, Object o, Exception e) throws Exception {

    }
 }

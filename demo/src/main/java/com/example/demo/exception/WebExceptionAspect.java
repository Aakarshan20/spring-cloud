package com.example.demo.exception;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import io.micrometer.common.util.StringUtils;
import jakarta.servlet.http.HttpServletResponse;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import java.io.IOException;
import java.io.PrintWriter;

@Aspect
@Component
public class WebExceptionAspect {
    private static final Logger logger = LoggerFactory.getLogger(WebExceptionAspect.class);

    // pointcut 作用在複數的annotation
    //@Pointcut("@annotation(org.springframework.web.bind.annotation.RequestMapping) || @annotation(org.springframework.web.bind.annotation.GetMapping)")
    @Pointcut("@annotation(org.springframework.web.bind.annotation.RequestMapping)")
    private void webPointcut(){

    }

    @Pointcut("@annotation(org.springframework.web.bind.annotation.GetMapping)")
    private void webPointcutForGetMapping(){

    }

    @AfterThrowing(pointcut = "webPointcut()", throwing = "e")
    public void handleThrowing(Exception e){
        e.printStackTrace();
        logger.error("發現異常!" + e.getMessage());
        //logger.error(new Gson().toJson(e.getStackTrace())); // <----- 不能這樣寫
        //Gson gson = new GsonBuilder().setPrettyPrinting().create(); // <----- 不能這樣寫
        //logger.error(gson.toJson(e.getStackTrace())); // <----- 不能這樣寫
        writeContent("出現異常"); // 用戶提示訊息
    }

    // 同時用兩個AhterThrowing 會被其中一個吃掉
    // @AfterThrowing(pointcut = "webPointcut()", throwing = "e")
    // public void handleThrowing(Exception e){
    //     e.printStackTrace();
    //     logger.error("發現異常!" + e.getMessage());
    //     //logger.error(new Gson().toJson(e.getStackTrace())); // <----- 不能這樣寫
    //     //Gson gson = new GsonBuilder().setPrettyPrinting().create(); // <----- 不能這樣寫
    //     //logger.error(gson.toJson(e.getStackTrace())); // <----- 不能這樣寫
    //     writeContent("出現異常"); // 用戶提示訊息
    // }

    // @AfterThrowing(pointcut = "webPointcut()", throwing = "e")
    @AfterThrowing(pointcut = "webPointcutForGetMapping()", throwing = "e")
    public void afterThrowing(Exception e) throws Throwable{
        logger.debug("exception 來了!");
        if(StringUtils.isNotBlank(e.getMessage())){
            writeContent(e.getMessage());
            //writeContent("出現異常!");
        } else {
            writeContent("參數錯誤!");
        }
    }

    private void writeContent(String content){
        HttpServletResponse response = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getResponse();
        response.reset();
        response.setCharacterEncoding("UTF-8");
        response.setHeader("Content-Type", "text/plain;charset=UTF-8");
        response.setHeader("icop-content-type", "exception");

        PrintWriter writer = null;

        try{
            writer = response.getWriter();
            writer.print((content==null ? "" : content));
            writer.flush();
            writer.close();
        } catch(IOException e){
            e.printStackTrace();
        }

        
    }
}

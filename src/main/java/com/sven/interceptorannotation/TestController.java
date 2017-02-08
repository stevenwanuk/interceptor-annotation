package com.sven.interceptorannotation;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController
{

    @RequestMapping("hello")
    public String hello(HttpServletRequest request) {
        
        
        return "hello " + request.getHeader("auto-added");
        
    }
}

package com.shiyanlou.springboot.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
// RestController 相当于同时使用 @Controller 和 @ResponseBody 注解
public class ShiyanlouController {
    // 使用@Value注解注入属性值
    @Value("${shiyanlou.springboot}")
    private String shiyanlou;
    @RequestMapping("shiyanlou")
    public String shiyanlou() {
        return shiyanlou;
    }
}

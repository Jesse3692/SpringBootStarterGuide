package com.shiyanlou.springboot.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
// RestController 相当于同时使用 @Controller 和 @ResponseBody 注解
public class ShiyanlouController {
    @RequestMapping("shiyanlou")
    public String shiyanlou() {
        return "Hello Shiyanlou";
    }
}

package com.shiyanlou.springboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

// 注意这里已经不是 @RestController 了和上个试验不同，因为需要返回视图，所以不能使用 @ResponseBody
@Controller
public class ShiyanlouController {

    @RequestMapping("shiyanlou")
    public String shiyanlou() {
        return "shiyanlou";
    }
}

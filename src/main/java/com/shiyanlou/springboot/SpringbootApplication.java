package com.shiyanlou.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.mybatis.spring.annotation.MapperScan;

// @SpringBootApplication 注解相当于同时使用 @EnableAutoConfiguration、@ComponentScan、@Configurations 三个注解
// @EnableAutoConfiguration 用于打开 Spring Boot 自动配置，而其余注解为 Spring 注解，这里不再赘述
@SpringBootApplication
// 扫描mapper接口位置
@MapperScan(basePackages = { "com.shiyanlou.springboot.dao" })
public class SpringbootApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootApplication.class, args);
	}

}

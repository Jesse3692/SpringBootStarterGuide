package com.shiyanlou.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;

// @SpringBootApplication 注解相当于同时使用 @EnableAutoConfiguration、@ComponentScan、@Configurations 三个注解
// @EnableAutoConfiguration 用于打开 Spring Boot 自动配置，而其余注解为 Spring 注解，这里不再赘述
// 通过 @ImportResource 加载 xml 配置文件
@ImportResource(value = "classpath:config.xml")
@SpringBootApplication
public class SpringbootApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootApplication.class, args);
	}

}

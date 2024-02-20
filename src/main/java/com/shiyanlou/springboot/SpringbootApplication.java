package com.shiyanlou.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

// @SpringBootApplication 注解相当于同时使用 @EnableAutoConfiguration、@ComponentScan、@Configurations 三个注解
// @EnableAutoConfiguration 用于打开 Spring Boot 自动配置，而其余注解为 Spring 注解，这里不再赘述
@SpringBootApplication
public class SpringbootApplication {

	// 设置配置类
	@Configuration
	static class WebCofig implements WebMvcConfigurer{
		// 重写 addResourceHandlers 方法
		@Override
		public void addResourceHandlers(ResourceHandlerRegistry registry){
			// 设置静态资源映射路径为 /**，资源位置为类路径下的 upload
			registry.addResourceHandler("/**").addResourceLocations("classpath:/upload/");
		}
	}

	public static void main(String[] args) {
		SpringApplication.run(SpringbootApplication.class, args);
	}

}

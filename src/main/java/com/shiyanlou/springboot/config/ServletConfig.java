package com.shiyanlou.springboot.config;

import org.springframework.boot.web.server.WebServerFactoryCustomizer;
import org.springframework.boot.web.servlet.server.ConfigurableServletWebServerFactory;
import org.springframework.context.annotation.Configuration;

// @Configuration 表示该类为配置类，该注解可以被@ComponentScan扫描到
// @Configuration
public class ServletConfig implements WebServerFactoryCustomizer<ConfigurableServletWebServerFactory> {
@Override
public void customize(ConfigurableServletWebServerFactory factory){
    // 设置端口为8080
    factory.setPort(8080);
}
}

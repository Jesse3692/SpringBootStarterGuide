package com.shiyanlou.springboot;

import javax.sql.DataSource;

import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

/**
 * 数据源配置
 */
@Configuration
public class DataSourceConfig {

    @Bean
    @Primary // 该注解表示为主数据源
    @ConfigurationProperties("app.datasource.first") // 读取前缀为app.datasource.first的属性
    public DataSourceProperties firstDataSourceProperties() {
        return new DataSourceProperties();
    }

    @Bean
    @Primary
    @ConfigurationProperties("app.datasource.first")
    public DataSource firstDataSource() {
        return firstDataSourceProperties().initializeDataSourceBuilder().build();
    }

    @Bean // 第二个数据源，不能加@Primary注解了
    @ConfigurationProperties("app.datasource.second")
    public DataSourceProperties secondDataSourceProperties() {
        return new DataSourceProperties();
    }

    @Bean
    @ConfigurationProperties("app.datasource.second")
    public DataSource secondDataSource() {
        return secondDataSourceProperties().initializeDataSourceBuilder().build();
    }

}

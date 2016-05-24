package com.rs.admin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

/**
 * Author: Oleh Osyka
 * Date: 5/20/2016
 * Time: 3:28 PM
 */
@SpringBootApplication
@Configuration
@PropertySource("classpath:service.properties")
@ComponentScan(basePackages = "com.rs.admin")
@EnableAutoConfiguration(exclude = {DataSourceAutoConfiguration.class})
public class AdminApplication {

    public static void main(String[] args) {
        SpringApplication application = new SpringApplication(AdminApplication.class);
        application.run(args);
    }

}

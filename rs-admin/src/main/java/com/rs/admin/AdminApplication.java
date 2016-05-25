package com.rs.admin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.web.client.RestOperations;
import org.springframework.web.client.RestTemplate;

/**
 * Author: Oleh Osyka
 * Date: 5/20/2016
 * Time: 3:28 PM
 */
@SpringBootApplication
@Configuration
@PropertySource({"classpath:credentials.properties", "classpath:service.properties"})
@ComponentScan(basePackages = "com.rs.admin")
@EnableAutoConfiguration(exclude = {DataSourceAutoConfiguration.class})
public class AdminApplication {

    @Bean
    public RestOperations asyncRestTemplate() {
        return new RestTemplate();
    }

    public static void main(String[] args) {
        SpringApplication application = new SpringApplication(AdminApplication.class);
        application.run(args);
    }

}

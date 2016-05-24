package com.rs.git;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.data.mongo.MongoDataAutoConfiguration;
import org.springframework.boot.autoconfigure.data.mongo.MongoRepositoriesAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.mongo.MongoAutoConfiguration;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.PropertySource;
import org.springframework.web.client.RestOperations;
import org.springframework.web.client.RestTemplate;

/**
 * Author: Oleh Osyka
 * Date: 5/23/2016
 * Time: 6:10 PM
 */
@SpringBootApplication
@PropertySource("classpath:service.properties")
@ComponentScan(basePackages = "com.rs.git")
@EnableAutoConfiguration(exclude = {
        DataSourceAutoConfiguration.class, HibernateJpaAutoConfiguration.class,
        MongoAutoConfiguration.class, MongoDataAutoConfiguration.class, MongoRepositoriesAutoConfiguration.class})
public class GitApplication {

    @Bean
    public RestOperations asyncRestTemplate() {
        return new RestTemplate();
    }

    public static void main(String[] args) {
        SpringApplication application = new SpringApplication(GitApplication.class);
        application.run(args);
    }
}

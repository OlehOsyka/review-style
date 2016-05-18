package com.rs.auth.configuration;

import com.rs.core.exception.RestGlobalExceptionResolver;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * Author: Oleh Osyka
 * Date: 4/14/2016
 * Time: 6:07 PM
 */
@Configuration
@EnableWebMvc
public class WebApplicationContext extends WebMvcConfigurerAdapter {

    @Override
    public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
        configurer.enable();
    }

    @Bean
    public HandlerExceptionResolver restGlobalExceptionResolver() {
        return new RestGlobalExceptionResolver();
    }

}

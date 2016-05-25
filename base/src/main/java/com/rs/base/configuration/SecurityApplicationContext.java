package com.rs.base.configuration;

import com.rs.core.security.RestAuthenticationEntryPoint;
import com.rs.core.security.RestAuthenticationFailureHandler;
import com.rs.core.security.RestAuthenticationSuccessHandler;
import com.rs.core.security.filter.RestErrorHandleFilter;
import com.rs.core.security.filter.RestUserAuthentificationFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.annotation.Order;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.security.web.access.channel.ChannelProcessingFilter;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.session.SessionManagementFilter;
import org.springframework.web.client.RestOperations;

/**
 * Author: Oleh Osyka
 * Date: 4/14/2016
 * Time: 12:28 PM
 */
@Primary
@EnableWebSecurity
@Configuration
@Order(SecurityProperties.ACCESS_OVERRIDE_ORDER)
public class SecurityApplicationContext extends WebSecurityConfigurerAdapter {

    private static final String SECURED_URL = "/api/**";

    @Value("${auth.uri}")
    protected String authUri;
    @Value("${auth.header.name}")
    protected String tokenHeader;
    @Value("${app.auth.header.name}")
    protected String appAuthHeader;
    @Value("${service.name}")
    protected String serviceName;

    @Autowired
    protected RestOperations restTemplate;
    @Autowired
    private AuthenticationEntryPoint authenticationEntryPoint;
    @Autowired
    private AuthenticationFailureHandler authenticationFailureHandler;
    @Autowired
    private AuthenticationSuccessHandler authenticationSuccessHandler;

    @Autowired
    @Qualifier("defaultAuthenticationManager")
    private AuthenticationManager authenticationManager;

    @Bean
    public AuthenticationEntryPoint initEntryPoint() {
        return new RestAuthenticationEntryPoint();
    }

    @Bean
    public AuthenticationFailureHandler initFailureHandler() {
        return new RestAuthenticationFailureHandler();
    }

    @Bean
    public AuthenticationSuccessHandler initSuccessHandler() {
        return new RestAuthenticationSuccessHandler();
    }

    @Bean(name = "defaultAuthenticationManager")
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.exceptionHandling()
                .and()
                .anonymous().disable()
                .httpBasic().disable()
                .formLogin().disable()
                .x509().disable()
                .jee().disable()
                .csrf().disable()
                .logout().disable()
                .rememberMe().disable()
                .authorizeRequests().antMatchers(SECURED_URL).authenticated()
                .and()
                .addFilterAfter(enableRestUserAuthFilter(), SessionManagementFilter.class)
                .addFilterBefore(enableRestErrorHandleFilter(), ChannelProcessingFilter.class);
    }

    @Bean
    public RestUserAuthentificationFilter enableRestUserAuthFilter() {
        return new RestUserAuthentificationFilter(authenticationManager,
                authenticationSuccessHandler,
                restTemplate,
                authUri,
                tokenHeader,
                SECURED_URL,
                appAuthHeader,
                String.valueOf(serviceName.hashCode()));
    }

    @Bean
    public RestErrorHandleFilter enableRestErrorHandleFilter() {
        return new RestErrorHandleFilter();
    }

}

package com.rs.auth.configuration;

import com.rs.auth.security.ApplicationAuthorizationFilter;
import com.rs.auth.security.UserAuthenticationFilter;
import com.rs.auth.service.IApplicationAuthorizationService;
import com.rs.auth.service.IUserAuthorizationService;
import com.rs.auth.service.IUserService;
import com.rs.core.security.RestAuthenticationEntryPoint;
import com.rs.core.security.RestAuthenticationFailureHandler;
import com.rs.core.security.RestAuthenticationSuccessHandler;
import com.rs.core.security.filter.RestErrorHandleFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.annotation.Order;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.security.web.access.channel.ChannelProcessingFilter;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.session.SessionManagementFilter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

/**
 * Author: Oleh Osyka
 * Date: 4/14/2016
 * Time: 12:28 PM
 */
@Primary
@Configuration
@Order(SecurityProperties.ACCESS_OVERRIDE_ORDER)
@EnableWebSecurity
public class SecurityApplicationContext extends WebSecurityConfigurerAdapter {

    @Autowired
    private AuthenticationEntryPoint authenticationEntryPoint;
    @Autowired
    private AuthenticationFailureHandler authenticationFailureHandler;
    @Autowired
    private AuthenticationSuccessHandler authenticationSuccessHandler;

    @Autowired
    private IApplicationAuthorizationService applicationAuthorizationService;
    @Autowired
    private IUserAuthorizationService authorizationService;
    @Autowired
    private IUserService userService;

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

    @Override
    protected void configure(AuthenticationManagerBuilder builder) throws Exception {
        builder.userDetailsService((UserDetailsService) userService);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.exceptionHandling()
                .authenticationEntryPoint(authenticationEntryPoint)
                .and()
                .anonymous().disable()
                .httpBasic().disable()
                .formLogin().disable()
                .x509().disable()
                .jee().disable()
                .csrf().disable()
                .logout().disable()
                .rememberMe().disable()
                .authorizeRequests().antMatchers("/api/user/register").authenticated()
                .and()
                .addFilterAfter(enableApplicationAuthFilter(), SessionManagementFilter.class)
                .addFilterAfter(enableUserAuthFilter(), ApplicationAuthorizationFilter.class)
                .addFilterBefore(enableRestErrorHandleFilter(), ChannelProcessingFilter.class);
    }

    @Bean(name = "defaultAuthenticationManager")
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }

    private ApplicationAuthorizationFilter enableApplicationAuthFilter() {
        return new ApplicationAuthorizationFilter(applicationAuthorizationService);
    }

    @Bean
    public RestErrorHandleFilter enableRestErrorHandleFilter() {
        return new RestErrorHandleFilter();
    }

    private UserAuthenticationFilter enableUserAuthFilter() {
        UserAuthenticationFilter userAuthenticationFilter = new UserAuthenticationFilter(authorizationService);
        userAuthenticationFilter.setRequiresAuthenticationRequestMatcher(new AntPathRequestMatcher("/api/user/register"));
        userAuthenticationFilter.setAuthenticationManager(authenticationManager);
        userAuthenticationFilter.setAuthenticationSuccessHandler(authenticationSuccessHandler);
        userAuthenticationFilter.setAuthenticationFailureHandler(authenticationFailureHandler);
        return userAuthenticationFilter;
    }

}

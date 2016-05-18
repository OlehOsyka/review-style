package com.rs.auth.security;

import com.rs.auth.service.IUserAuthorizationService;
import com.rs.core.commons.dto.auth.User;
import org.springframework.security.authentication.AuthenticationCredentialsNotFoundException;
import org.springframework.security.authentication.CredentialsExpiredException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static com.rs.auth.commons.utils.AuthConversionUtils.convertToAuthentication;

/**
 * Author: Oleh Osyka
 * Date: 4/15/2016
 * Time: 4:49 PM
 */
public class UserAuthenticationFilter extends UsernamePasswordAuthenticationFilter {

    private IUserAuthorizationService authorizationService;

    public UserAuthenticationFilter(IUserAuthorizationService authorizationService) {
        this.authorizationService = authorizationService;
    }

    @Override
    public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) res;

        if (!requiresAuthentication(request, response)) {
            chain.doFilter(request, response);
            return;
        }

        String token = request.getHeader("X-Auth-Token");
        if (token == null) throw new AuthenticationCredentialsNotFoundException("Unauthorized access.");
        User user = authorizationService.authorize(token);
        if (user == null) throw new CredentialsExpiredException("Token has expired. Repeat authorization.");
        Authentication authRequest = convertToAuthentication(user);

        SecurityContextHolder.getContext().setAuthentication(authRequest);
        chain.doFilter(request, response);
    }
}

package com.rs.auth.security;


import com.rs.auth.service.IApplicationAuthorizationService;
import org.springframework.security.authentication.BadCredentialsException;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ApplicationAuthorizationFilter implements Filter {

    private IApplicationAuthorizationService applicationAuthorizationService;

    public ApplicationAuthorizationFilter(IApplicationAuthorizationService applicationAuthorizationService) {
        this.applicationAuthorizationService = applicationAuthorizationService;
    }

    @Override
    public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain)
            throws IOException, ServletException {

        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) res;

        String secretKey = request.getHeader("X-Authorization");

        if (!applicationAuthorizationService.isAppAuthorized(secretKey)) {
            throw new BadCredentialsException("Application is not authorized to access the service");
        }

        chain.doFilter(request, response);
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    }

    @Override
    public void destroy() {
    }
}

package com.rs.core.security.filter;


import com.rs.core.commons.dto.JsonApiResponse;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.web.client.RestOperations;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static org.springframework.http.HttpMethod.GET;

public class RestApplicationAuthorizationFilter implements Filter {

    private final String applicationAuthorizationHeader;
    private final String applicationAuthorizationToken;
    private final String authUri;
    private final List<String> cachedAppKeys;

    protected RestOperations restTemplate;

    public RestApplicationAuthorizationFilter(RestOperations restTemplate,
                                              String authUri,
                                              String applicationAuthorizationHeader,
                                              String applicationAuthorizationToken) {
        this.restTemplate = restTemplate;
        this.authUri = authUri;
        this.applicationAuthorizationHeader = applicationAuthorizationHeader;
        this.applicationAuthorizationToken = applicationAuthorizationToken;
        this.cachedAppKeys = new ArrayList<>();
    }

    @Override
    public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain)
            throws IOException, ServletException {

        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) res;

        String secretKey = request.getHeader(applicationAuthorizationHeader);

        if (!cachedAppKeys.contains(secretKey) && !isRegister(secretKey)) {
            throw new BadCredentialsException("Application is not authorized to access the service");
        }

        chain.doFilter(request, response);
    }

    private boolean isRegister(String secretKey) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.set(applicationAuthorizationHeader, applicationAuthorizationToken);

        String requestUri = authUri + "/app/authorize?auth=" + secretKey;
        ResponseEntity<JsonApiResponse> exchange = restTemplate.exchange(requestUri, GET, new HttpEntity<>(headers), JsonApiResponse.class);
        return exchange.getBody().isResult();
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    }

    @Override
    public void destroy() {
    }
}

package com.rs.core.service;


import com.rs.core.commons.entity.UsernamePasswordAuthenticationTokenDetailed;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.client.RestOperations;
import org.springframework.web.client.RestTemplate;

public class BaseWebServiceClient {

    @Autowired
    private RestOperations restTemplate;

    private HttpHeaders httpHeaders;
    private String serviceUrl;
    private String securityTokenHeader;
    private String secretKey;
    private String authUserToken;

    public BaseWebServiceClient(String serviceUrl, String securityTokenHeader, String secretKey, String authUserToken) {
        // in case of HTTPS using HTTP as default will fail and make a lot of problem
        this.serviceUrl = serviceUrl;
        this.securityTokenHeader = securityTokenHeader;
        this.secretKey = secretKey;
        this.httpHeaders = new HttpHeaders();
        this.httpHeaders.add(securityTokenHeader, secretKey);
        this.authUserToken = authUserToken;
    }

    protected HttpHeaders getRequestHeaders() {
        httpHeaders.set(authUserToken, getTokenForCurrentUser());
        return httpHeaders;
    }

    protected String getSecretKey() {
        return secretKey;
    }

    protected String getSecurityTokenHeader() {
        return securityTokenHeader;
    }

    public String getServiceUrl() {
        return serviceUrl;
    }

    public RestOperations getRestTemplate() {
        return restTemplate;
    }

    protected String getTokenForCurrentUser() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication instanceof UsernamePasswordAuthenticationTokenDetailed) {
            return ((UsernamePasswordAuthenticationTokenDetailed) authentication).getUserToken();
        }
        return StringUtils.EMPTY;
    }

}

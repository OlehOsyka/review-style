package com.rs.core.service.impl;

import com.rs.core.commons.dto.JsonApiResponse;
import com.rs.core.commons.dto.auth.Credentials;
import com.rs.core.commons.dto.auth.User;
import com.rs.core.commons.dto.auth.UserWithToken;
import com.rs.core.service.BaseWebServiceClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import static org.springframework.http.HttpMethod.GET;
import static org.springframework.http.HttpMethod.POST;

/**
 * Author: Oleh Osyka
 * Date: 5/18/2016
 * Time: 12:25 PM
 */
@Service
public class WebAuthService extends BaseWebServiceClient {

    private static final Logger LOGGER = LoggerFactory.getLogger(WebAuthService.class);

    public WebAuthService(String serviceUrl, String securityTokenHeader, String secretKey, String authUserToken) {
        super(serviceUrl, securityTokenHeader, secretKey, authUserToken);
    }

    public void appAuthorize(String appToken) {
        ResponseEntity<JsonApiResponse> exchange = getRestTemplate().exchange(getServiceUrl() + "/app/authorize?auth=" + appToken, GET, new HttpEntity<>(getRequestHeaders()), JsonApiResponse.class);
        LOGGER.info("HTTP Status code " + exchange.getStatusCode() + ". Rest invocation result for command '/app/authorize': " + exchange.getBody().isResult());
    }

    public User userAuthorize(String appToken) {
        ResponseEntity<JsonApiResponse> exchange = getRestTemplate().exchange(getServiceUrl() + "/user/authorize?auth=" + appToken, GET, new HttpEntity<>(getRequestHeaders()), JsonApiResponse.class);
        LOGGER.info("HTTP Status code " + exchange.getStatusCode() + ". Rest invocation result for command '/user/authorize': " + exchange.getBody().isResult());
        return Optional.ofNullable(exchange.getBody())
                .filter(JsonApiResponse::isResult)
                .map(response -> response.getData(User.class))
                .orElseGet(() -> null);
    }

    public void userRegister(String email, String password, List<String> roles) {
        User user = new User(email, password, roles);
        ResponseEntity<JsonApiResponse> exchange = getRestTemplate().exchange(getServiceUrl() + "/user/register", POST, new HttpEntity<>(user, getRequestHeaders()), JsonApiResponse.class);
        LOGGER.info("HTTP Status code " + exchange.getStatusCode() + ". Rest invocation result for command '/user/register': " + exchange.getBody().isResult());
    }

    public UserWithToken userAuthentication(String username, String password) {
        Credentials credentials = new Credentials(username, password);
        return userAuthentication(credentials);
    }

    public UserWithToken userAuthentication(Credentials credentials) {
        ResponseEntity<JsonApiResponse> exchange = getRestTemplate().exchange(getServiceUrl() + "/user/authentication", POST, new HttpEntity<>(credentials, getRequestHeaders()), JsonApiResponse.class);
        LOGGER.info("HTTP Status code " + exchange.getStatusCode() + ". Rest invocation result for command '/user/authentication': " + exchange.getBody().isResult());
        return Optional.ofNullable(exchange.getBody())
                .filter(JsonApiResponse::isResult)
                .map(response -> response.getData(UserWithToken.class))
                .orElseGet(() -> null);
    }
}

package com.rs.core.service.impl;

import com.fasterxml.jackson.core.type.TypeReference;
import com.rs.core.commons.dto.JsonApiResponse;
import com.rs.core.commons.dto.admin.Project;
import com.rs.core.commons.dto.auth.User;
import com.rs.core.service.BaseWebServiceClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static org.springframework.http.HttpMethod.GET;
import static org.springframework.http.HttpMethod.POST;

/**
 * Author: Oleh Osyka
 * Date: 5/23/2016
 * Time: 4:23 PM
 */
@Service
public class WebAdminService extends BaseWebServiceClient {

    private static final Logger LOGGER = LoggerFactory.getLogger(WebAdminService.class);

    public WebAdminService(String serviceUrl, String securityTokenHeader, String secretKey, String authUserToken) {
        super(serviceUrl, securityTokenHeader, secretKey, authUserToken);
    }

    public void projectAdd(Project project) {
        if (project.getOwner() == null) {
            Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
            User user = new User();
            user.setEmail(String.valueOf(authentication.getPrincipal()));
            user.setRoles(authentication.getAuthorities()
                    .stream()
                    .map(GrantedAuthority::getAuthority)
                    .collect(Collectors.toList()));
            project.setOwner(user);
        }
        if (CollectionUtils.isEmpty(project.getParticipants())) {
            project.getParticipants().add(project.getOwner());
        }
        ResponseEntity<JsonApiResponse> exchange = getRestTemplate().exchange(getServiceUrl() + "/project/add", POST, new HttpEntity<>(project, getRequestHeaders()), JsonApiResponse.class);
        LOGGER.info("HTTP Status code " + exchange.getStatusCode() + ". Rest invocation result for command '/project/add': " + exchange.getBody().isResult());
    }

    public List<Project> projectGet(String email) {
        ResponseEntity<JsonApiResponse> exchange = getRestTemplate().exchange(getServiceUrl() + "/project/get?email=" + email, GET, new HttpEntity<>(getRequestHeaders()), JsonApiResponse.class);
        LOGGER.info("HTTP Status code " + exchange.getStatusCode() + ". Rest invocation result for command '/project/get': " + exchange.getBody().isResult());
        return Optional.ofNullable(exchange.getBody())
                .filter(JsonApiResponse::isResult)
                .map(response -> response.getData(new TypeReference<List<Project>>() {
                }))
                .orElseGet(() -> null);
    }

    public Project projectNameGet(String projectName) {
        ResponseEntity<JsonApiResponse> exchange = getRestTemplate().exchange(getServiceUrl() + "/project/get/one?name=" + projectName, GET, new HttpEntity<>(getRequestHeaders()), JsonApiResponse.class);
        LOGGER.info("HTTP Status code " + exchange.getStatusCode() + ". Rest invocation result for command '/project/get': " + exchange.getBody().isResult());
        return Optional.ofNullable(exchange.getBody())
                .filter(JsonApiResponse::isResult)
                .map(response -> response.getData(Project.class))
                .orElseGet(() -> null);
    }
}

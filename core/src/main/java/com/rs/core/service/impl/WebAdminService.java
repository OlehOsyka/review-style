package com.rs.core.service.impl;

import com.rs.core.commons.dto.JsonApiResponse;
import com.rs.core.commons.dto.admin.Project;
import com.rs.core.service.BaseWebServiceClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

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
        ResponseEntity<JsonApiResponse> exchange = getRestTemplate().exchange(getServiceUrl() + "/user/register", POST, new HttpEntity<>(project, getRequestHeaders()), JsonApiResponse.class);
        LOGGER.info("HTTP Status code " + exchange.getStatusCode() + ". Rest invocation result for command '/user/register': " + exchange.getBody().isResult());
    }
}

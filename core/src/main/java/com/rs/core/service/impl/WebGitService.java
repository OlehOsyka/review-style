package com.rs.core.service.impl;

import com.fasterxml.jackson.core.type.TypeReference;
import com.rs.core.commons.dto.JsonApiResponse;
import com.rs.core.commons.dto.git.Tree;
import com.rs.core.service.BaseWebServiceClient;
import com.rs.core.service.WebVcsService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Optional;

import static org.springframework.http.HttpMethod.GET;

/**
 * Author: Oleh Osyka
 * Date: 5/25/2016
 * Time: 12:04 PM
 */
public class WebGitService extends BaseWebServiceClient implements WebVcsService {

    private static final Logger LOGGER = LoggerFactory.getLogger(WebGitService.class);

    public WebGitService(String serviceUrl, String securityTokenHeader, String secretKey, String authUserToken) {
        super(serviceUrl, securityTokenHeader, secretKey, authUserToken);
    }

    @Override
    public void projectDownload(String address, String projectName) {
        ResponseEntity<JsonApiResponse> exchange = getRestTemplate().exchange(getServiceUrl() + "/repo/download?address=" + address + "&projectName=" + projectName, GET, new HttpEntity<>(getRequestHeaders()), JsonApiResponse.class);
        LOGGER.info("HTTP Status code " + exchange.getStatusCode() + ". Rest invocation result for command '/download': " + exchange.getBody().isResult());
    }

    @Override
    public List<Tree> projectTree(String projectName) {
        ResponseEntity<JsonApiResponse> exchange = getRestTemplate().exchange(getServiceUrl() + "/repo/tree?projectName=" + projectName, GET, new HttpEntity<>(getRequestHeaders()), JsonApiResponse.class);
        LOGGER.info("HTTP Status code " + exchange.getStatusCode() + ". Rest invocation result for command '/" + projectName + "/tree': " + exchange.getBody().isResult());
        return Optional.ofNullable(exchange.getBody())
                .filter(JsonApiResponse::isResult)
                .map(response -> response.getData(new TypeReference<List<Tree>>() {
                }))
                .orElseGet(() -> null);
    }


}

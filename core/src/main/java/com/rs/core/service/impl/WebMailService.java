package com.rs.core.service.impl;


import com.rs.core.commons.dto.JsonApiResponse;
import com.rs.core.commons.dto.mail.Email;
import com.chi.core.service.web.BaseWebServiceClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import static org.springframework.http.HttpMethod.POST;

@Service
public class WebMailService extends BaseWebServiceClient {

    private static final Logger LOGGER = LoggerFactory.getLogger(WebMailService.class);

    public WebMailService(String serviceUrl, String securityTokenHeader, String secretKey, String authUserToken) {
        super(serviceUrl, securityTokenHeader, secretKey, authUserToken);
    }

    public void mail(String message, String subject, String senderAddress, String receiverAddress) {
        Email email = new Email(message, subject, senderAddress, receiverAddress);
        ResponseEntity<JsonApiResponse> exchange = getRestTemplate().exchange(getServiceUrl() + "/mail", POST, new HttpEntity<>(email, getRequestHeaders()), JsonApiResponse.class);
        LOGGER.info("HTTP Status code " + exchange.getStatusCode() + ". Rest invocation result for command '/mail': " + exchange.getBody().isResult());
    }
}

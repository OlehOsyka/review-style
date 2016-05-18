package com.rs.auth.service.impl;

import com.rs.auth.service.IApplicationAuthorizationService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.stream.Collectors;

/**
 * Author: Oleh Osyka
 * Date: 5/17/2016
 * Time: 12:25 PM
 */
@Service
public class ApplicationAuthorizationService implements IApplicationAuthorizationService {

    private static final Logger LOGGER = LoggerFactory.getLogger(ApplicationAuthorizationService.class);
    private List<String> keys;

    @PostConstruct
    private void loadProperties() {
        Properties prop = new Properties();
        keys = new ArrayList<>();
        try {
            ClassPathResource resource = new ClassPathResource("application.key.properties");
            prop.load(resource.getInputStream());
        } catch (IOException e) {
            LOGGER.error("Can't load file with application keys.", e);
        }
        keys.addAll(prop.stringPropertyNames().stream()
                .map(prop::getProperty)
                .collect(Collectors.toList()));
    }

    @Override
    public boolean isAppAuthorized(String appHash) {
        return keys.contains(appHash);
    }

}

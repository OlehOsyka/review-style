package com.rs.base.configuration;

import com.rs.core.service.WebVcsService;
import com.rs.core.service.impl.WebAdminService;
import com.rs.core.service.impl.WebAuthService;
import com.rs.core.service.impl.WebGitService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ServiceConfiguration {

    @Value("${auth.uri}")
    protected String authServiceUri;
    @Value("${admin.uri}")
    protected String adminServiceUri;
    @Value("${vcs.uri}")
    protected String vcsServiceUri;
    @Value("${app.auth.header.name}")
    protected String appAuthHeader;
    @Value("${auth.header.name}")
    protected String userAuthHeader;
    @Value("${service.name}")
    protected String serviceName;

    @Bean
    public WebAuthService webAuthService() {
        return new WebAuthService(
                authServiceUri,
                appAuthHeader,
                String.valueOf(serviceName.hashCode()),
                userAuthHeader);
    }

    @Bean
    public WebAdminService webAdminService() {
        return new WebAdminService(
                adminServiceUri,
                appAuthHeader,
                String.valueOf(serviceName.hashCode()),
                userAuthHeader);
    }

    @Bean
    public WebVcsService webVcsServiceService() {
        return new WebGitService(
                vcsServiceUri,
                appAuthHeader,
                String.valueOf(serviceName.hashCode()),
                userAuthHeader);
    }
}

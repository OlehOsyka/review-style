package com.rs.core.security.filter;

import com.rs.core.commons.dto.JsonApiResponse;
import com.rs.core.commons.dto.auth.Credentials;
import com.rs.core.commons.dto.auth.User;
import com.rs.core.commons.dto.auth.UserWithToken;
import com.rs.core.commons.entity.UsernamePasswordAuthenticationTokenDetailed;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.*;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.web.client.RestOperations;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Optional;
import java.util.stream.Collectors;

import static org.springframework.http.HttpMethod.GET;

/**
 * Author: Oleh Osyka
 * Date: 4/20/2016
 * Time: 3:19 PM
 */
public class RestUserAuthentificationFilter extends UsernamePasswordAuthenticationFilter {

    private static Logger LOGGER = LoggerFactory.getLogger(RestUserAuthentificationFilter.class);
    private final String applicationAuthorizationHeader;
    private final String applicationAuthorizationToken;

    protected boolean continueChainBeforeSuccessfulAuthentication;
    protected boolean postOnly;

    protected RestOperations restTemplate;
    protected String authUri;
    protected String tokenHeader;

    public RestUserAuthentificationFilter(AuthenticationManager authenticationManager,
                                          AuthenticationSuccessHandler authenticationSuccessHandler,
                                          RestOperations restTemplate,
                                          String authUri,
                                          String tokenHeader,
                                          String securedPath, String applicationAuthorizationHeader, String applicationAuthorizationToken) {
        this.restTemplate = restTemplate;
        this.authUri = authUri;
        this.tokenHeader = tokenHeader;
        this.applicationAuthorizationHeader = applicationAuthorizationHeader;
        this.applicationAuthorizationToken = applicationAuthorizationToken;
        this.setRequiresAuthenticationRequestMatcher(new AntPathRequestMatcher(securedPath));
        this.setAuthenticationManager(authenticationManager);
        this.setAuthenticationSuccessHandler(authenticationSuccessHandler);
        this.setUsernameParameter("username");
        this.setPasswordParameter("password");
    }

    public Authentication attemptAuthentication(HttpServletRequest request,
                                                HttpServletResponse response) throws AuthenticationException {
        Authentication authResult = authByToken(request);
        if (authResult == null) {
            authResult = authByCredentials(request);
        }
        return authResult;
    }

    private Authentication authByToken(HttpServletRequest request) {
        String token = request.getHeader(this.tokenHeader);
        return StringUtils.isEmpty(token) ? null : getAuthentication(token);
    }

    private Authentication authByCredentials(HttpServletRequest request) throws AuthenticationException {
        String username = obtainUsername(request);
        String password = obtainPassword(request);

        if (username == null) {
            username = "";
        }

        if (password == null) {
            password = "";
        }

        username = username.trim();

        try {
            Credentials credentials = new Credentials(username, password);
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_JSON);
            headers.set(applicationAuthorizationHeader, applicationAuthorizationToken);

            ResponseEntity<JsonApiResponse> exchange = restTemplate.exchange(authUri + "/user/authentication", HttpMethod.POST, new HttpEntity<>(credentials, headers), JsonApiResponse.class);
            Optional<UserWithToken> optUser = Optional.ofNullable(exchange.getBody())
                    .filter(JsonApiResponse::isResult)
                    .map(response -> response.getData(UserWithToken.class));
            if (optUser.isPresent()) {
                UserWithToken user = optUser.get();
                return new UsernamePasswordAuthenticationToken(
                        user.getEmail(),
                        user.getPassword(),
                        user.getRoles()
                                .stream()
                                .map(SimpleGrantedAuthority::new)
                                .collect(Collectors.toSet()));
            } else {
                throw new RuntimeException("Bad response." + exchange.getBody().getMessage());
            }
        } catch (Throwable e) {
            throw new BadCredentialsException("Can't perform authentication by credentials. " + e.getMessage(), e);
        }
    }

    private Authentication getAuthentication(String token) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.set(tokenHeader, token);
        headers.set(applicationAuthorizationHeader, applicationAuthorizationToken);

        String requestUri = authUri + "/user/authorize?auth=" + token;
        ResponseEntity<JsonApiResponse> exchange = restTemplate.exchange(requestUri, GET, new HttpEntity<>(headers), JsonApiResponse.class);

        User user = Optional.ofNullable(exchange.getBody())
                .filter(JsonApiResponse::isResult)
                .map(response -> response.getData(User.class))
                .orElseGet(() -> null);
        if (user != null) {
            return new UsernamePasswordAuthenticationTokenDetailed(
                    user.getEmail(),
                    user.getPassword(),
                    user.getRoles()
                            .stream()
                            .map(SimpleGrantedAuthority::new)
                            .collect(Collectors.toSet()),
                    token);
        }
        return null;
    }

    @Override
    public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) res;

        if (!requiresAuthentication(request, response)) {
            chain.doFilter(request, response);
            return;
        }

        Authentication authResult = SecurityContextHolder.getContext().getAuthentication();
        if (authResult == null) {
            try {
                authResult = attemptAuthentication(request, response);
                if (authResult == null) {
                    // return immediately as subclass has indicated that it hasn't completed
                    // authentication
                    return;
                }
            } catch (AuthenticationException e) {
                // Authentication failed
                unsuccessfulAuthentication(request, response, e);
                return;
            }
        }
        // Authentication success
        SecurityContextHolder.getContext().setAuthentication(authResult);
        chain.doFilter(request, response);
    }

    @Override
    public void setPostOnly(boolean postOnly) {
        this.postOnly = postOnly;
    }

    public void setContinueChainBeforeSuccessfulAuthentication(
            boolean continueChainBeforeSuccessfulAuthentication) {
        this.continueChainBeforeSuccessfulAuthentication = continueChainBeforeSuccessfulAuthentication;
    }
}

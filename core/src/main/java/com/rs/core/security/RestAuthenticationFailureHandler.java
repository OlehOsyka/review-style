package com.rs.core.security;

import com.rs.core.commons.dto.JsonApiResponse;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.rs.core.api.ApiErrorCodes;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationFailureHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static javax.servlet.http.HttpServletResponse.SC_UNAUTHORIZED;

/**
 * Author: Oleh Osyka
 * Date: 4/14/2016
 * Time: 2:21 PM
 */
public class RestAuthenticationFailureHandler extends SimpleUrlAuthenticationFailureHandler {

    private final ObjectMapper json = new ObjectMapper();

    @Override
    public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response, AuthenticationException exception) throws IOException, ServletException {
        JsonApiResponse r = JsonApiResponse.newResponse()
                .failed()
                .statusCode(SC_UNAUTHORIZED)
                .error(ApiErrorCodes.ACCESS_DENIED, exception.getMessage());
        response.setStatus(SC_UNAUTHORIZED);
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        response.getWriter().write(json.writeValueAsString(r));
    }
}

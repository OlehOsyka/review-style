package com.rs.core.security.filter;

import com.rs.core.commons.dto.JsonApiResponse;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.core.Ordered;

import javax.servlet.*;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static com.rs.core.api.ApiErrorCodes.ACCESS_DENIED;
import static javax.servlet.http.HttpServletResponse.SC_OK;
import static javax.servlet.http.HttpServletResponse.SC_UNAUTHORIZED;

/**
 * Author: Oleh Osyka
 * Date: 4/25/2016
 * Time: 4:50 PM
 */
public class RestErrorHandleFilter implements Filter, Ordered {

    private final ObjectMapper json = new ObjectMapper();

    @Override
    public int getOrder() {
        return Integer.MIN_VALUE;
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        //nothing to do
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        try {
            chain.doFilter(request, response);
        } catch (Exception ex) {
            JsonApiResponse r = JsonApiResponse.newResponse()
                    .failed()
                    .statusCode(SC_UNAUTHORIZED)
                    .error(ACCESS_DENIED, ex.getMessage());
            ((HttpServletResponse) response).setStatus(SC_OK);
            response.setContentType("application/json");
            response.setCharacterEncoding("UTF-8");
            response.getWriter().write(json.writeValueAsString(r));
        }
    }

    @Override
    public void destroy() {
        //nothing to do
    }
}

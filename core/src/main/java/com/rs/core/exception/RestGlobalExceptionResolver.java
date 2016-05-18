package com.rs.core.exception;

import com.rs.core.commons.dto.JsonApiResponse;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.rs.core.api.ApiErrorCodes;
import org.springframework.core.Ordered;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.json.MappingJackson2JsonView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

import static javax.servlet.http.HttpServletResponse.SC_INTERNAL_SERVER_ERROR;

/**
 * Author: Oleh Osyka
 * Date: 4/25/2016
 * Time: 5:17 PM
 */
public class RestGlobalExceptionResolver implements HandlerExceptionResolver, Ordered {

    private final ObjectMapper json = new ObjectMapper();

    @Override
    public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) {
        JsonApiResponse error;
        if (ex instanceof RestException) {
            error = JsonApiResponse.newResponse()
                    .failed()
                    .statusCode(((RestException) ex).getStatusCode())
                    .error(((RestException) ex).getErrorCode(), ex.getMessage());
        } else {
            error = JsonApiResponse.newResponse()
                    .failed()
                    .statusCode(SC_INTERNAL_SERVER_ERROR)
                    .error(ApiErrorCodes.UNHANDLED_ERROR, ex.getMessage());
        }
        Map props = json.convertValue(error, Map.class);
        ModelAndView mav = new ModelAndView(new MappingJackson2JsonView());
        mav.addAllObjects(props);
        return mav;
    }

    @Override
    public int getOrder() {
        return Integer.MIN_VALUE;
    }
}

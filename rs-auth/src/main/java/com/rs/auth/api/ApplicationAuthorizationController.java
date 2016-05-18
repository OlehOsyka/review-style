package com.rs.auth.api;


import com.rs.auth.service.IApplicationAuthorizationService;
import com.rs.core.commons.dto.JsonApiResponse;
import com.rs.core.exception.RestException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import static com.rs.core.api.ApiErrorCodes.ACCESS_DENIED;
import static org.springframework.http.HttpStatus.OK;
import static org.springframework.http.HttpStatus.UNAUTHORIZED;

/**
 * Author: Oleh Osyka
 * Date: 5/17/2016
 * Time: 2:59 PM
 */
@RestController
@RequestMapping(value = "/api/app")
public class ApplicationAuthorizationController {

    @Autowired
    private IApplicationAuthorizationService applicationAuthorizationService;

    @ResponseStatus(OK)
    @RequestMapping(value = "/authorize", method = RequestMethod.GET)
    public JsonApiResponse authorize(@RequestParam(value = "auth") String token) {
        if (!applicationAuthorizationService.isAppAuthorized(token)) {
            throw new RestException("Unauthorized application.", UNAUTHORIZED.value(), ACCESS_DENIED);
        }
        return JsonApiResponse.newResponse()
                .successfull()
                .statusCode(OK.value());
    }

}

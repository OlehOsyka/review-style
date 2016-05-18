package com.rs.auth.api;

import com.rs.auth.service.IUserAuthorizationService;
import com.rs.auth.service.IUserService;
import com.rs.core.commons.dto.JsonApiResponse;
import com.rs.core.commons.dto.auth.Credentials;
import com.rs.core.commons.dto.auth.User;
import com.rs.core.exception.RestException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import static com.rs.auth.commons.utils.AuthConversionUtils.convertFromUser;
import static com.rs.core.api.ApiErrorCodes.ACCESS_DENIED;
import static com.rs.core.api.ApiErrorCodes.REGISTRATION_FAILURE;
import static com.rs.core.commons.utils.CryptUtils.md5;
import static org.springframework.http.HttpStatus.*;

/**
 * Author: Oleh Osyka
 * Date: 4/21/2016
 * Time: 5:24 PM
 */
@RestController
@RequestMapping(value = "/api/user")
public class UserAuthorizationController {

    @Autowired
    private IUserService userService;
    @Autowired
    private IUserAuthorizationService authorizationService;

    @ResponseStatus(OK)
    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public JsonApiResponse register(@RequestBody User user) {
        com.rs.auth.commons.entity.User registeredUser = userService.register(user);
        if (registeredUser == null) {
            throw new RestException("Failed to complete registration.", INTERNAL_SERVER_ERROR.value(), REGISTRATION_FAILURE);
        }
        return JsonApiResponse.newResponse()
                .successfull()
                .statusCode(OK.value())
                .data(null);
    }

    @ResponseStatus(OK)
    @RequestMapping(value = "/authentication ", method = RequestMethod.POST)
    public JsonApiResponse authentication(@RequestBody Credentials credentials) {
        com.rs.auth.commons.entity.User user = userService.getActiveByEmail(credentials.getUsername());
        if (!user.getPassword().equalsIgnoreCase(md5(credentials.getPassword()))) {
            throw new RestException("Bad credentials.", UNAUTHORIZED.value(), ACCESS_DENIED);
        }
        return JsonApiResponse.newResponse()
                .successfull()
                .statusCode(OK.value())
                .data(authorizationService.authentificate(convertFromUser(user)));
    }

    @ResponseStatus(OK)
    @RequestMapping(value = "/authorize", method = RequestMethod.GET)
    public JsonApiResponse authorize(@RequestParam(value = "auth") String token) {
        User user = authorizationService.authorize(token);
        if (user == null) {
            throw new RestException("Token has expired. Repeat authorization.", UNAUTHORIZED.value(), ACCESS_DENIED);
        }
        return JsonApiResponse.newResponse()
                .successfull()
                .statusCode(OK.value())
                .data(new User(user.getEmail(), null, user.getRoles()));
    }

}

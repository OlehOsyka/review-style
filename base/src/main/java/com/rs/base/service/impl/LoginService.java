package com.rs.base.service.impl;

import com.rs.base.service.ILoginService;
import com.rs.core.commons.dto.auth.Credentials;
import com.rs.core.commons.dto.auth.UserWithToken;
import com.rs.core.commons.entity.UsernamePasswordAuthenticationTokenDetailed;
import com.rs.core.exception.RestException;
import com.rs.core.service.impl.WebAuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;

import static com.rs.core.api.ApiErrorCodes.ACCESS_DENIED;
import static org.springframework.http.HttpStatus.UNAUTHORIZED;

/**
 * Author: Oleh Osyka
 * Date: 5/19/2016
 * Time: 11:49 AM
 */
@Service
public class LoginService implements ILoginService {

    @Autowired
    private WebAuthService webAuthService;

    @Override
    public void login(Credentials credentials) {
        UserWithToken userWithToken = webAuthService.userAuthentication(credentials);
        if (userWithToken == null) {
            throw new RestException("Can't perform authorization.", UNAUTHORIZED.value(), ACCESS_DENIED);
        }
        Authentication authResult = new UsernamePasswordAuthenticationTokenDetailed(
                userWithToken.getEmail(),
                userWithToken.getPassword(),
                userWithToken.getRoles()
                        .stream()
                        .map(SimpleGrantedAuthority::new)
                        .collect(Collectors.toSet()),
                userWithToken.getToken());
        // Authentication success
        SecurityContextHolder.getContext().setAuthentication(authResult);
    }
}

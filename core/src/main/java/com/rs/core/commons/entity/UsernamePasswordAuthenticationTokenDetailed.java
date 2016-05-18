package com.rs.core.commons.entity;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;

import java.util.Collection;

/**
 * Author: Oleh Osyka
 * Date: 5/17/2016
 * Time: 5:48 PM
 */
public class UsernamePasswordAuthenticationTokenDetailed extends UsernamePasswordAuthenticationToken {

    private String userToken;

    public UsernamePasswordAuthenticationTokenDetailed(Object principal, Object credentials, String token) {
        super(principal, credentials);
        this.userToken = token;
    }

    public UsernamePasswordAuthenticationTokenDetailed(Object principal, Object credentials,
                                                       Collection<? extends GrantedAuthority> authorities, String token) {
        super(principal, credentials, authorities);
        this.userToken = token;
    }

    public String getUserToken() {
        return userToken;
    }
}

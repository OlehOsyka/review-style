package com.rs.core.commons.dto.auth;

/**
 * Author: Oleh Osyka
 * Date: 4/21/2016
 * Time: 7:09 PM
 */
public class UserWithToken extends User {

    private String token;

    public UserWithToken(User user) {
        setEmail(user.getEmail());
        setRoles(user.getRoles());
    }

    public UserWithToken withToken(String token) {
        this.token = token;
        return this;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}

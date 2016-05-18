package com.rs.core.commons.dto.auth;

/**
 * Author: Oleh Osyka
 * Date: 4/20/2016
 * Time: 3:40 PM
 */
public class Credentials {

    private String username;
    private String password;

    public Credentials() {
    }

    public Credentials(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}

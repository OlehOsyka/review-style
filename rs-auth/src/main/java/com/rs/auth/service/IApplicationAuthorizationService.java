package com.rs.auth.service;

/**
 * Author: Oleh Osyka
 * Date: 5/17/2016
 * Time: 12:23 PM
 */
public interface IApplicationAuthorizationService {

    boolean isAppAuthorized(String appHash);

}

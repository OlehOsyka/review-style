package com.rs.base.service;

import com.rs.core.commons.dto.auth.Credentials;

/**
 * Author: Oleh Osyka
 * Date: 5/19/2016
 * Time: 11:49 AM
 */
public interface ILoginService {

    void login(Credentials credentials);
}

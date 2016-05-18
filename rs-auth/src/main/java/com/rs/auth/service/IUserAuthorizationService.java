package com.rs.auth.service;

import com.rs.core.commons.dto.auth.User;
import com.rs.core.commons.dto.auth.UserWithToken;

/**
 * Author: Oleh Osyka
 * Date: 4/21/2016
 * Time: 7:30 PM
 */
public interface IUserAuthorizationService {

    UserWithToken authentificate(User user);

    User authorize(String token);

}

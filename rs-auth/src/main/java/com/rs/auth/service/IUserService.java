package com.rs.auth.service;

import com.rs.auth.commons.entity.User;
import com.rs.core.service.BaseService;

/**
 * Author: Oleh Osyka
 * Date: 4/12/2016
 * Time: 5:53 PM
 */
public interface IUserService extends BaseService<User, String> {

    User getActiveByEmail(String email);

    User register(com.rs.core.commons.dto.auth.User user);

}

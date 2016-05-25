package com.rs.admin.service;

import com.rs.admin.commons.entity.User;
import com.rs.core.service.BaseService;

import java.util.Collection;
import java.util.List;

/**
 * Author: Oleh Osyka
 * Date: 5/25/2016
 * Time: 3:27 PM
 */
public interface IUserService extends BaseService<User, String> {
    void addAll(Collection<User> users);

    User getByEmail(String email);

    List<User> getParticipantsByEmail(List<String> email);
}

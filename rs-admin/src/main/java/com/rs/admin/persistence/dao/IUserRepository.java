package com.rs.admin.persistence.dao;

import com.rs.admin.commons.entity.User;
import com.rs.core.persistence.jpa.BaseJpaRepository;

import java.util.Collection;
import java.util.List;

/**
 * Author: Oleh Osyka
 * Date: 5/25/2016
 * Time: 3:27 PM
 */
public interface IUserRepository extends BaseJpaRepository<User, String> {

    User findByEmail(String email);

    List<User> findByEmailIn(Collection<String> emails);
}

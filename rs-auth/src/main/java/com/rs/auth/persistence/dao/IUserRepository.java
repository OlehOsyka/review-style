package com.rs.auth.persistence.dao;


import com.rs.auth.commons.entity.User;
import com.rs.core.persistence.jpa.BaseJpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


/**
 * Author: Oleh Osyka
 * Date: 4/12/2016
 * Time: 12:19 PM
 */
public interface IUserRepository extends BaseJpaRepository<User, String> {

    @Query("SELECT u FROM User u where u.email = :email AND u.active = TRUE")
    User getActiveByEmail(@Param("email") String email);
}

package com.rs.git.persistence.dao;

import com.rs.core.persistence.mongo.BaseMongoRepository;
import com.rs.git.commons.entity.GitUser;

/**
 * Author: Oleh Osyka
 * Date: 5/24/2016
 * Time: 2:07 PM
 */
public interface IGitUserRepository extends BaseMongoRepository<GitUser, String> {
}

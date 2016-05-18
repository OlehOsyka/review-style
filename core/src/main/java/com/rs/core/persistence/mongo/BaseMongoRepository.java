package com.rs.core.persistence.mongo;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.NoRepositoryBean;

import java.io.Serializable;
import java.util.List;

/**
 * Author: Oleh Osyka
 * Date: 4/13/2016
 * Time: 12:50 PM
 */
@NoRepositoryBean
public interface BaseMongoRepository<ENTITY, ID extends Serializable> extends MongoRepository<ENTITY, ID> {

    List<ENTITY> getAll();

    ENTITY get(ID id);

    void add(ENTITY entity);

    void delete(ENTITY entity);

    void update(ENTITY entity);

}

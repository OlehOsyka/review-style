package com.rs.core.persistence.mongo.impl;

import com.rs.core.persistence.mongo.BaseMongoRepository;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.repository.query.MongoEntityInformation;
import org.springframework.data.mongodb.repository.support.SimpleMongoRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;
import java.util.List;

/**
 * Author: Oleh Osyka
 * Date: 5/17/2016
 * Time: 6:33 PM
 */
@Repository
@Transactional
public class BaseMongoRepositoryImpl<ENTITY, ID extends Serializable> extends SimpleMongoRepository<ENTITY, ID>
        implements BaseMongoRepository<ENTITY, ID> {

    protected final MongoOperations mongoOperations;

    public BaseMongoRepositoryImpl(MongoEntityInformation<ENTITY, ID> metadata, MongoOperations mongoOperations) {
        super(metadata, mongoOperations);
        this.mongoOperations = mongoOperations;
    }

    @Override
    public List<ENTITY> getAll() {
        return findAll();
    }

    @Override
    public ENTITY get(ID id) {
        return findOne(id);
    }

    @Override
    public void add(ENTITY entity) {
        save(entity);
    }

    @Override
    public void update(ENTITY entity) {
        save(entity);
    }
}

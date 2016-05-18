package com.rs.core.persistence.jpa.impl;

import com.rs.core.persistence.jpa.BaseJpaRepository;
import org.springframework.data.jpa.repository.support.JpaEntityInformation;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.io.Serializable;
import java.util.List;

/**
 * Author: Oleh Osyka
 * Date: 4/13/2016
 * Time: 1:03 PM
 */
@Repository
@Transactional
public class BaseJpaRepositoryImpl<ENTITY, ID extends Serializable> extends SimpleJpaRepository<ENTITY, ID>
        implements BaseJpaRepository<ENTITY, ID> {

    protected final EntityManager entityManager;

    public BaseJpaRepositoryImpl(JpaEntityInformation<ENTITY, ID> entityInformation, EntityManager entityManager) {
        super(entityInformation, entityManager);
        this.entityManager = entityManager;
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

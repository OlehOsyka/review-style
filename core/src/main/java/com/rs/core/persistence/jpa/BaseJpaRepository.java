package com.rs.core.persistence.jpa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

import java.io.Serializable;
import java.util.List;

/**
 * Author: Oleh Osyka
 * Date: 4/12/2016
 * Time: 5:30 PM
 */
@NoRepositoryBean
public interface BaseJpaRepository<ENTITY, ID extends Serializable> extends JpaRepository<ENTITY, ID> {

    List<ENTITY> getAll();

    ENTITY get(ID id);

    void add(ENTITY entity);

    void delete(ENTITY entity);

    void update(ENTITY entity);
}

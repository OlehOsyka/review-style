package com.rs.core.service;

import java.io.Serializable;
import java.util.List;

/**
 * Author: Oleh Osyka
 * Date: 4/12/2016
 * Time: 6:14 PM
 */
public interface BaseService<ENTITY, ID extends Serializable> {

    List<ENTITY> getAll();

    ENTITY get(ID id);

    void add(ENTITY entity);

    void delete(ENTITY entity);

    void update(ENTITY entity);
}

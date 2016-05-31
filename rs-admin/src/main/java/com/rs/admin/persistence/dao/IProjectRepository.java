package com.rs.admin.persistence.dao;

import com.rs.admin.commons.entity.Project;
import com.rs.core.persistence.jpa.BaseJpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * Author: Oleh Osyka
 * Date: 5/20/2016
 * Time: 4:54 PM
 */
public interface IProjectRepository extends BaseJpaRepository<Project, Long> {
    Project findByName(String name);
}

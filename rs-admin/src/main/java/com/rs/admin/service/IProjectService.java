package com.rs.admin.service;

import com.rs.admin.commons.entity.Issue;
import com.rs.admin.commons.entity.Project;
import com.rs.core.service.BaseService;

import java.util.List;

/**
 * Author: Oleh Osyka
 * Date: 5/23/2016
 * Time: 3:30 PM
 */
public interface IProjectService extends BaseService<Project, Long> {

    Project getByName(String name);
}

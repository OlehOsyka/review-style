package com.rs.base.service;

import com.rs.core.commons.dto.admin.Project;
import com.rs.core.commons.dto.git.Tree;

import java.util.List;

/**
 * Author: Oleh Osyka
 * Date: 5/25/2016
 * Time: 12:20 PM
 */
public interface IProjectService {

    void add(Project project);

    void get(String projectName);

    List<Tree> getTree(String projectName);

    List<Project> getForUser(String email);
}

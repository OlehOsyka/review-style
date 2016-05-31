package com.rs.admin.service;

import com.rs.admin.commons.entity.Issue;
import com.rs.admin.commons.entity.Project;

import java.util.List;
import java.util.Set;

/**
 * Author: Oleh Osyka
 * Date: 5/25/2016
 * Time: 5:37 PM
 */
public interface IAdminService {
    void initProject(Project project);

    void addIssue(Long id, Issue issue);

    void addIssues(Long id, List<Issue> newIssues);

    List<com.rs.core.commons.dto.admin.Project> findByUser(String email);

    com.rs.core.commons.dto.admin.Project findByName(String name);
}

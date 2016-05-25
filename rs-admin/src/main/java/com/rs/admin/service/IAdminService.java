package com.rs.admin.service;

import com.rs.admin.commons.entity.Issue;
import com.rs.admin.commons.entity.Project;

import java.util.List;

/**
 * Author: Oleh Osyka
 * Date: 5/25/2016
 * Time: 5:37 PM
 */
public interface IAdminService {
    void initProject(Project project);

    void addIssue(Long id, Issue issue);

    void addIssues(Long id, List<Issue> newIssues);
}

package com.rs.admin.commons.utils;

import com.rs.admin.commons.entity.Project;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import static com.rs.admin.commons.utils.IssueConversionUtils.convertFromIssues;
import static com.rs.admin.commons.utils.IssueConversionUtils.convertToIssues;
import static com.rs.admin.commons.utils.UserConversionUtils.*;

/**
 * Author: Oleh Osyka
 * Date: 5/23/2016
 * Time: 3:36 PM
 */
public final class ProjectConversionUtils {

    private ProjectConversionUtils() {
    }

    public static Project convertToProject(com.rs.core.commons.dto.admin.Project coreProject) {
        Project project = new Project();
        project.setId(coreProject.getId());
        project.setName(coreProject.getName());
        project.setDescription(coreProject.getDescription());
        project.setVcsAddress(coreProject.getVcsAddress());
        project.setOwner(convertToUser(coreProject.getOwner()));
        project.setParticipants(convertToParticipants(coreProject.getParticipants()));
        project.setIssues(convertToIssues(coreProject.getIssues()));
        return project;
    }

    public static com.rs.core.commons.dto.admin.Project convertFromProject(Project project) {
        com.rs.core.commons.dto.admin.Project coreProject = new com.rs.core.commons.dto.admin.Project();
        coreProject.setId(project.getId());
        coreProject.setName(project.getName());
        coreProject.setDescription(project.getDescription());
        coreProject.setVcsAddress(project.getVcsAddress());
        coreProject.setOwner(convertFromUser(project.getOwner()));
        coreProject.setParticipants(convertFromParticipants(project.getParticipants()));
        coreProject.setIssues(convertFromIssues(project.getIssues()));
        return coreProject;
    }

    public static List<com.rs.core.commons.dto.admin.Project> convertFromProjects(Collection<Project> projects) {
        return projects.stream()
                .map(ProjectConversionUtils::convertFromProject)
                .collect(Collectors.toList());
    }

}

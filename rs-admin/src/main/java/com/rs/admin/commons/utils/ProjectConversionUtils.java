package com.rs.admin.commons.utils;

import com.rs.admin.commons.entity.Project;

import static com.rs.admin.commons.utils.UserConversionUtils.convertToParticipants;
import static com.rs.admin.commons.utils.UserConversionUtils.convertToUser;

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
        project.setVcsAdress(coreProject.getVcsAdress());
        project.setOwner(convertToUser(coreProject.getOwner()));
        project.setParticipants(convertToParticipants(coreProject.getParticipants()));
        project.setIssues(IssueConversionUtils.convertToIssues(coreProject.getIssues()));
        return project;
    }

}

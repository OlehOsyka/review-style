package com.rs.admin.service.impl;

import com.rs.admin.commons.entity.Issue;
import com.rs.admin.commons.entity.Project;
import com.rs.admin.commons.entity.User;
import com.rs.admin.service.IAdminService;
import com.rs.admin.service.IIssueService;
import com.rs.admin.service.IProjectService;
import com.rs.admin.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rs.admin.commons.utils.ProjectConversionUtils.convertFromProject;
import static com.rs.admin.commons.utils.ProjectConversionUtils.convertFromProjects;
import static java.util.Collections.singletonList;

/**
 * Author: Oleh Osyka
 * Date: 5/25/2016
 * Time: 5:37 PM
 */
@Service
public class AdminService implements IAdminService {

    @Autowired
    private IUserService userService;
    @Autowired
    private IProjectService projectService;
    @Autowired
    private IIssueService issueService;

    @Override
    public void initProject(Project project) {
        // save owner
        User owner = saveToDb(project.getOwner());
        project.setOwner(owner);

        // save participants
        Set<User> participants = project.getParticipants()
                .stream()
                .map(this::saveToDb)
                .collect(Collectors.toSet());
        project.setParticipants(participants);

        // save project
        projectService.add(project);
    }

    private User saveToDb(User user) {
        User userFromDb = userService.getByEmail(user.getEmail());
        if (userFromDb == null) {
            userService.add(user);
            userFromDb = userService.getByEmail(user.getEmail());
        }
        return userFromDb;
    }

    @Override
    public void addIssue(Long id, Issue issue) {

        addIssues(id, singletonList(issue));
    }

    private Issue saveToDb(Issue user) {
        //todo
        return null;
    }

    @Override
    public void addIssues(Long id, List<Issue> newIssues) {
        newIssues = newIssues.stream()
                .map(this::saveToDb)
                .collect(Collectors.toList());

        Project project = projectService.get(id);
        List<Issue> oldIssues = project.getIssues();
        for (Issue i : newIssues) {
            oldIssues.remove(i);
            oldIssues.add(i);
        }
        projectService.update(project);
    }

    @Override
    public List<com.rs.core.commons.dto.admin.Project> findByUser(String email) {
        User user = userService.getUserByEmailAndFetchProjects(email);
        return convertFromProjects(user.getProjects());
    }

    @Override
    public com.rs.core.commons.dto.admin.Project findByName(String name) {
        return convertFromProject(projectService.getByName(name));
    }


}

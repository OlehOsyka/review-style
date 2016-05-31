package com.rs.base.service.impl;

import com.rs.base.service.IProjectService;
import com.rs.core.commons.dto.admin.Project;
import com.rs.core.commons.dto.git.Tree;
import com.rs.core.exception.RestException;
import com.rs.core.service.WebVcsService;
import com.rs.core.service.impl.WebAdminService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.rs.core.api.ApiErrorCodes.EMPTY_PROJECT_NAME;
import static com.rs.core.api.ApiErrorCodes.EMPTY_VCS_ADDRESS;
import static org.springframework.http.HttpStatus.BAD_REQUEST;

/**
 * Author: Oleh Osyka
 * Date: 5/25/2016
 * Time: 12:20 PM
 */
@Service
public class ProjectService implements IProjectService {

    @Autowired
    private WebAdminService adminService;
    @Autowired
    private WebVcsService vcsService;

    @Override
    public void add(Project project) {
        String projectName = project.getName();
        if (StringUtils.isEmpty(projectName)) {
            throw new RestException("Empty name specified for project " + project.getName(), BAD_REQUEST.value(), EMPTY_PROJECT_NAME);
        }
        String vcsAddress = project.getVcsAddress();
        if (StringUtils.isEmpty(vcsAddress)) {
            throw new RestException("Empty VCS address specified for project " + project.getName(), BAD_REQUEST.value(), EMPTY_VCS_ADDRESS);
        }
        vcsService.projectDownload(vcsAddress, projectName);
        // vcs getContributors
        // auth register contributors
        // update project participants
        adminService.projectAdd(project);
        // rules analyze
        // analytic create graphs
        // admin add issues
        // admin assign issues
        // notification send notify
    }

    @Override
    public List<Tree> getTree(String projectName) {
        return vcsService.projectTree(projectName);

    }

    @Override
    public List<Project> getForUser(String email) {
        return adminService.projectGet(email);
    }

    @Override
    public Project getProject(String projectName) {
        return adminService.projectNameGet(projectName);
    }
}

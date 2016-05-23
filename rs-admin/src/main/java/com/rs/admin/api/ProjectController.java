package com.rs.admin.api;


import com.rs.admin.service.IProjectService;
import com.rs.admin.service.impl.IssueService;
import com.rs.core.commons.dto.JsonApiResponse;
import com.rs.core.commons.dto.admin.Issue;
import com.rs.core.commons.dto.admin.Project;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.rs.admin.commons.utils.IssueConversionUtils.convertToIssue;
import static com.rs.admin.commons.utils.IssueConversionUtils.convertToIssues;
import static com.rs.admin.commons.utils.ProjectConversionUtils.convertToProject;
import static org.springframework.http.HttpStatus.OK;

/**
 * Author: Oleh Osyka
 * Date: 5/23/2016
 * Time: 3:24 PM
 */
@RestController
@RequestMapping(value = "/api/project")
public class ProjectController {

    @Autowired
    private IProjectService projectService;
    @Autowired
    private IssueService issueService;

    @ResponseStatus(OK)
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public JsonApiResponse projectAdd(@RequestBody Project project) {
        projectService.add(convertToProject(project));
        return JsonApiResponse.newResponse()
                .successfull()
                .statusCode(OK.value())
                .data(null);
    }

    @ResponseStatus(OK)
    @RequestMapping(value = "/{id}/add/issue", method = RequestMethod.POST)
    public JsonApiResponse projectAddIssue(@PathVariable("id") Long id,
                                           @RequestBody Issue issue) {
        com.rs.admin.commons.entity.Issue newIssue = convertToIssue(issue);
        issueService.add(newIssue);
        projectService.addIssue(id, newIssue);
        return JsonApiResponse.newResponse()
                .successfull()
                .statusCode(OK.value())
                .data(null);
    }

    @ResponseStatus(OK)
    @RequestMapping(value = "/{id}/add/issues", method = RequestMethod.POST)
    public JsonApiResponse projectAddIssues(@PathVariable("id") Long id,
                                            @RequestBody List<Issue> issues) {
        List<com.rs.admin.commons.entity.Issue> newIssues = convertToIssues(issues);
        issueService.add(newIssues);
        projectService.addIssues(id, newIssues);
        return JsonApiResponse.newResponse()
                .successfull()
                .statusCode(OK.value())
                .data(null);
    }
}

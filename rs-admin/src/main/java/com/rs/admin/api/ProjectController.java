package com.rs.admin.api;


import com.rs.admin.service.IAdminService;
import com.rs.admin.service.IProjectService;
import com.rs.core.commons.dto.JsonApiResponse;
import com.rs.core.commons.dto.admin.Issue;
import com.rs.core.commons.dto.admin.Project;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

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
    private IAdminService adminService;

    @ResponseStatus(OK)
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public JsonApiResponse projectAdd(@RequestBody Project project) {
        adminService.initProject(convertToProject(project));
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
        adminService.addIssue(id, newIssue);
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
        adminService.addIssues(id, newIssues);
        return JsonApiResponse.newResponse()
                .successfull()
                .statusCode(OK.value())
                .data(null);
    }

    @ResponseStatus(OK)
    @RequestMapping(value = "/get", method = RequestMethod.GET)
    public JsonApiResponse projectGetByEmail(@RequestParam("email") String email) {
        List<Project> projects = adminService.findByUser(email);
        return JsonApiResponse.newResponse()
                .successfull()
                .statusCode(OK.value())
                .data(projects);
    }

    @ResponseStatus(OK)
    @RequestMapping(value = "/get/one", method = RequestMethod.GET)
    public JsonApiResponse projectGetByName(@RequestParam("name") String name) {
        Project project = adminService.findByName(name);
        return JsonApiResponse.newResponse()
                .successfull()
                .statusCode(OK.value())
                .data(project);
    }
}

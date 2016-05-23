package com.rs.admin.api;


import com.rs.admin.service.IProjectService;
import com.rs.core.commons.dto.JsonApiResponse;
import com.rs.core.commons.dto.admin.Project;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    @ResponseStatus(OK)
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public JsonApiResponse register(@RequestBody Project project) {
        projectService.add(convertToProject(project));
        return JsonApiResponse.newResponse()
                .successfull()
                .statusCode(OK.value())
                .data(null);
    }
}

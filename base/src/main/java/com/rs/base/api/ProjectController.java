package com.rs.base.api;

import com.rs.base.service.IProjectService;
import com.rs.core.commons.dto.admin.Project;
import com.rs.core.commons.dto.git.Tree;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Author: Oleh Osyka
 * Date: 5/23/2016
 * Time: 2:10 PM
 */
@Controller
public class ProjectController {

    @Autowired
    private IProjectService projectService;

    @RequestMapping(value = "/project/add")
    public String projectAddPage() {
        return "project_add";
    }

    @RequestMapping(value = "/public/project/add", method = RequestMethod.POST)
    public String projectAdd(Project project) {
        projectService.add(project);
        return "dashboard";
    }

    @RequestMapping(value = "/public/project/{projectName}/tree", method = RequestMethod.GET)
    @ResponseBody
    public List<Tree> projectTree(@PathVariable("projectName") String projectName) {
        return projectService.getTree(projectName);
    }
}

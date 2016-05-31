package com.rs.base.api;

import com.rs.base.service.IProjectService;
import com.rs.core.commons.dto.admin.Project;
import com.rs.core.commons.dto.git.Tree;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

    @RequestMapping(value = "/project/files")
    public ModelAndView projectFileManagerPage(@RequestParam("name") String projectName) {
        Map<String, Object> attr = new HashMap<>();
        attr.put("project", projectService.getProject(projectName));
        return new ModelAndView("project_file_manager", attr);
    }

    @RequestMapping(value = "/public/project/add", method = RequestMethod.POST)
    public String projectAdd(Project project) {
        projectService.add(project);
        return "dashboard";
    }

    @RequestMapping(value = "/public/project/get", method = RequestMethod.GET)
    @ResponseBody
    public List<Project> projectGet(@RequestParam("email") String email) {
        return projectService.getForUser(email);
    }

    @RequestMapping(value = "/public/project/tree", method = RequestMethod.GET)
    @ResponseBody
    public List<Tree> projectTree(@RequestParam("name") String name) {
        return projectService.getTree(name);
    }
}

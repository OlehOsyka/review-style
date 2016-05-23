package com.rs.base.api;

import com.rs.core.commons.dto.admin.Project;
import com.rs.core.service.impl.WebAdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Author: Oleh Osyka
 * Date: 5/23/2016
 * Time: 2:10 PM
 */
@Controller
public class ProjectController {

    @Autowired
    private WebAdminService adminService;

    @RequestMapping(value = "/project/add")
    public String projectAddPage() {
        return "project_add";
    }

    @RequestMapping(value = "/public/project/add", method = RequestMethod.POST)
    public String projectAdd(Project project) {
        adminService.projectAdd(project);
        return "dashboard";
    }
}

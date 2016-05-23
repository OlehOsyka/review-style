package com.rs.base.api;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Author: Oleh Osyka
 * Date: 5/23/2016
 * Time: 2:10 PM
 */
@Controller
public class ProjectController {

    @RequestMapping(value = "/project/add")
    public String projectAddPage() {
        return "project_add";
    }
}

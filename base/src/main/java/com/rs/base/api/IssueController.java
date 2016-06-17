package com.rs.base.api;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Author: Oleh Osyka
 * Date: 6/6/2016
 * Time: 6:01 PM
 */
@Controller
public class IssueController {

    @RequestMapping(value = "/issue/add")
    public String ruleAddPage() {
        return "rule_add";
    }

    @RequestMapping(value = "/issues")
    public String rules() {
        return "rules";
    }

    @RequestMapping(value = "/issue")
    public String issue() {
        return "issue";
    }
}

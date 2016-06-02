package com.rs.base.api;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Author: Oleh Osyka
 * Date: 6/2/2016
 * Time: 12:45 PM
 */
@Controller
public class RuleController {

    @RequestMapping(value = "/rule/add")
    public String ruleAddPage() {
        return "rule_add";
    }

    @RequestMapping(value = "/rules")
    public String rules() {
        return "rules";
    }
}

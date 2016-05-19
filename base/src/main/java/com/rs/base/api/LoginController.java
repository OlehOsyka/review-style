package com.rs.base.api;

import com.rs.base.service.ILoginService;
import com.rs.core.commons.dto.auth.Credentials;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Author: Oleh Osyka
 * Date: 4/20/2016
 * Time: 4:49 PM
 */
@Controller
public class LoginController {

    @Autowired
    private ILoginService loginService;

    @RequestMapping(value = "/")
    public String home() {
        return SecurityContextHolder.getContext().getAuthentication() == null ? "login" : "dashboard";
    }

    @RequestMapping(value = "/api/login")
    public String login(@RequestBody Credentials credentials) {
        loginService.login(credentials);
        return "dashboard";
    }
}

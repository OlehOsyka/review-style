package com.rs.base.api;

import com.rs.base.service.ILoginService;
import com.rs.core.commons.dto.auth.Credentials;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

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
    public String homePage() {
        return SecurityContextHolder.getContext().getAuthentication() == null ? "login" : "dashboard";
    }

    @RequestMapping(value = "/login")
    public String loginPage() {
        return "login";
    }

    @RequestMapping(value = "/login/recovery")
    public String loginRecoveryPage() {
        return "login_password_recover";
    }

    @RequestMapping(value = "/public/login", method = RequestMethod.POST)
    public String login(Credentials credentials) {
        loginService.login(credentials);
        return "dashboard";
    }

    @RequestMapping(value = "/api/login/recovery", method = RequestMethod.GET)
    public String loginRecovery(@RequestParam String email) {
        //todo
        return "dashboard";
    }

    public static void main(String[] args) {
        System.out.println("review-style".hashCode());
    }
}

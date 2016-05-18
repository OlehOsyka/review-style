package com.rs.auth.service.impl;

import com.rs.auth.commons.entity.User;
import com.rs.auth.commons.entity.UserRole;
import com.rs.auth.service.IUserService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.HashSet;
import java.util.Set;

import static com.rs.core.commons.utils.CryptUtils.md5;

/**
 * Author: Oleh Osyka
 * Date: 5/18/2016
 * Time: 4:40 PM
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:application-test-context.xml")
public class UserServiceTest {

    @Autowired
    private IUserService userService;

    @Test
    @Rollback
    public void get() throws Exception {
        User u = new User();
        u.setEmail("oleh.osyka@chisw.com");
        u.setPassword("111111");

        userService.add(u);

        User fromDB = userService.get("oleh.osyka@chisw.com");

        Assert.assertEquals(u, fromDB);
    }

    @Test(expected = RuntimeException.class)
    @Rollback
    public void getByEmailNonActive() throws Exception {
        User u = new User();
        u.setEmail("oleh.osyka@chisw.com");
        u.setPassword("111111");

        userService.add(u);

        User fromDB = userService.getActiveByEmail("oleh.osyka@chisw.com");

        Assert.assertNull(fromDB);
    }

    @Test
    @Rollback
    public void getByEmailActive() throws Exception {
        User u = new User();
        u.setEmail("oleh.osyka@chisw.com");
        u.setPassword("111111");
        u.setActive(true);

        userService.add(u);

        User fromDB = userService.getActiveByEmail("oleh.osyka@chisw.com");

        Assert.assertEquals(u, fromDB);
    }

    @Test
    public void initRootUser() throws Exception {
        User u = new User();
        u.setEmail("oleh.osyka@chisw.com");
        u.setPassword(md5("111111"));
        u.setActive(true);
        Set<UserRole> roles = new HashSet<>();
        UserRole ur = new UserRole();
        ur.setRole("ADMIN");
        ur.setUser(u);
        roles.add(ur);
        u.setRoles(roles);

        userService.add(u);
    }

}
package com.rs.auth.service.impl;

import com.rs.auth.commons.entity.User;
import com.rs.auth.commons.entity.UserRole;
import com.rs.auth.persistence.dao.IUserRepository;
import com.rs.auth.service.IUserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import javax.annotation.PostConstruct;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static com.rs.auth.commons.utils.AuthConversionUtils.convertToUser;
import static com.rs.auth.commons.utils.AuthConversionUtils.convertToUserDetails;
import static com.rs.core.commons.utils.CryptUtils.md5;

/**
 * Author: Oleh Osyka
 * Date: 4/12/2016
 * Time: 5:55 PM
 */
@Primary
@Service
public class UserService implements IUserService, UserDetailsService {

    private static final Logger LOGGER = LoggerFactory.getLogger(UserService.class);

    @Autowired
    private IUserRepository userRepository;

    @PostConstruct
    public void initRootUser() throws Exception {
        User u = new User();
        u.setEmail("oleh.osyka@gmail.com");
        u.setPassword(md5("111111"));
        u.setActive(true);
        Set<UserRole> roles = new HashSet<>();
        UserRole ur = new UserRole();
        ur.setRole("ADMIN");
        ur.setUser(u);
        UserRole ur1 = new UserRole();
        ur1.setRole("LEAD");
        ur1.setUser(u);
        UserRole ur2 = new UserRole();
        ur2.setRole("DEVELOPER");
        ur2.setUser(u);
        UserRole ur3 = new UserRole();
        ur3.setRole("REVIEWER");
        ur3.setUser(u);
        roles.add(ur);
        roles.add(ur1);
        roles.add(ur2);
        roles.add(ur3);
        u.setRoles(roles);
        try {
            add(u);
        } catch (Throwable exception) {
            //root user already exists
            LOGGER.info("Root user already exists. Continue...");
        }
    }

    @Override
    public User getActiveByEmail(String email) {
        Assert.hasText(email, "Please specify email");
        User activeByEmail = userRepository.getActiveByEmail(email);
        if (activeByEmail == null) throw new RuntimeException("No active users with provided credentials");
        return activeByEmail;
    }

    @Override
    public User register(com.rs.core.commons.dto.auth.User user) {
        Assert.notNull(user.getEmail());
        user.setPassword(md5(user.getPassword()));
        add(convertToUser(user));
        User registered = getActiveByEmail(user.getEmail());
        registered.setPassword(null);
        return registered;
    }

    @Override
    public List<User> getAll() {
        return userRepository.getAll();
    }

    @Override
    public User get(String s) {
        return userRepository.get(s);
    }

    @Override
    public void add(User user) {
        userRepository.add(user);
    }

    @Override
    public void delete(User user) {
        userRepository.delete(user);
    }

    @Override
    public void update(User user) {
        userRepository.update(user);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = getActiveByEmail(username);
        return convertToUserDetails(user);
    }
}

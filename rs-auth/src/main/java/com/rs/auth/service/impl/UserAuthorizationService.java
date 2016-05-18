package com.rs.auth.service.impl;

import com.rs.auth.service.IUserAuthorizationService;
import com.rs.core.commons.dto.auth.User;
import com.rs.core.commons.dto.auth.UserWithToken;
import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.math.BigInteger;
import java.security.SecureRandom;

import static com.rs.auth.commons.utils.AuthConversionUtils.convertToAuthentication;

/**
 * Author: Oleh Osyka
 * Date: 4/21/2016
 * Time: 7:44 PM
 */
@Service
public class UserAuthorizationService implements IUserAuthorizationService {

    @Value("${service.max.cache.size}")
    private int MAX_SIZE;

    private Cache<String, User> cache;
    private SecureRandom random = new SecureRandom();

    @PostConstruct
    private void init() {
        cache = CacheBuilder.newBuilder()
                .maximumSize(MAX_SIZE)
                .build();
    }

    @Override
    public UserWithToken authentificate(User user) {
        SecurityContextHolder.getContext().setAuthentication(convertToAuthentication(user));
        String token = nextSessionId();
        cache.put(token, user);
        return new UserWithToken(user).withToken(token);
    }

    @Override
    public User authorize(String token) {
        return cache.getIfPresent(token);
    }

    private String nextSessionId() {
        return new BigInteger(130, random).toString(32);
    }
}

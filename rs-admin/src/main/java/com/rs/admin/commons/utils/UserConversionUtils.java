package com.rs.admin.commons.utils;


import com.rs.admin.commons.entity.User;
import com.rs.admin.commons.entity.UserRole;

import java.util.Collection;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * Author: Oleh Osyka
 * Date: 5/23/2016
 * Time: 3:43 PM
 */
public final class UserConversionUtils {

    private UserConversionUtils() {
    }

    public static User convertToUser(com.rs.core.commons.dto.auth.User coreUser) {
        User user = new User();
        user.setEmail(coreUser.getEmail());
        user.setRoles(coreUser.getRoles()
                .stream()
                .map(role -> {
                    UserRole urole = new UserRole();
                    urole.setRole(role);
                    urole.setUser(user);
                    return urole;
                }).collect(Collectors.toSet()));
        return user;
    }

    public static Set<User> convertToParticipants(Collection<com.rs.core.commons.dto.auth.User> coreUsers) {
        return coreUsers.stream()
                .map(UserConversionUtils::convertToUser)
                .collect(Collectors.toSet());
    }
}

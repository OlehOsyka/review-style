package com.rs.auth.commons.utils;

import com.rs.auth.commons.entity.User;
import com.rs.auth.commons.entity.UserRole;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.HashSet;
import java.util.Optional;
import java.util.stream.Collectors;

import static java.util.Optional.ofNullable;

/**
 * Author: Oleh Osyka
 * Date: 4/19/2016
 * Time: 2:52 PM
 */
public final class AuthConversionUtils {

    private AuthConversionUtils() {
    }

    public static UserDetails convertToUserDetails(User user) {
        Optional<HashSet<SimpleGrantedAuthority>> opt = ofNullable(user.getRoles())
                .map(
                        userRoles -> userRoles
                                .stream()
                                .map(ur -> new SimpleGrantedAuthority(ur.getRole()))
                                .collect(Collectors.toCollection(HashSet::new))
                );
        Collection<SimpleGrantedAuthority> roles = opt.isPresent() ? opt.get() : new HashSet<>();
        return new org.springframework.security.core.userdetails.User(user.getEmail(), user.getPassword(), roles);
    }

    public static User convertToUser(Authentication authentication) {
        User user = new User();
        user.setEmail(authentication.getName());
        user.setRoles(authentication.getAuthorities()
                .stream()
                .map(grantedAuthority -> {
                            UserRole role = new UserRole();
                            role.setRole(grantedAuthority.getAuthority());
                            return role;
                        }
                )
                .collect(Collectors.toSet()));
        return user;
    }

    public static User convertToUser(com.rs.core.commons.dto.auth.User coreUser) {
        User authUser = new User();
        authUser.setEmail(coreUser.getEmail());
        authUser.setPassword(coreUser.getPassword());
        authUser.setActive(true);
        authUser.setRoles(coreUser.getRoles()
                .stream()
                .map(role -> {
                            UserRole urole = new UserRole();
                            urole.setRole(role);
                            urole.setUser(authUser);
                            return urole;
                        }
                )
                .collect(Collectors.toSet()));
        return authUser;
    }

    public static com.rs.core.commons.dto.auth.User convertFromUser(User authUser) {
        com.rs.core.commons.dto.auth.User coreUser = new com.rs.core.commons.dto.auth.User();
        coreUser.setEmail(authUser.getEmail());
        coreUser.setPassword(authUser.getPassword());
        coreUser.setRoles(authUser.getRoles()
                .stream()
                .map(UserRole::getRole)
                .collect(Collectors.toList()));
        return coreUser;
    }

    public static Authentication convertToAuthentication(com.rs.core.commons.dto.auth.User coreUser) {
        return new UsernamePasswordAuthenticationToken(
                coreUser.getEmail(),
                coreUser.getPassword(),
                coreUser.getRoles()
                        .stream()
                        .map(SimpleGrantedAuthority::new)
                        .collect(Collectors.toSet()));
    }

}

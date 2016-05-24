package com.rs.git.commons.utils;

import com.rs.core.commons.dto.auth.User;
import com.rs.git.commons.entity.GitUser;
import org.kohsuke.github.GHPersonSet;
import org.kohsuke.github.GHUser;

import java.io.IOException;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * Author: Oleh Osyka
 * Date: 5/24/2016
 * Time: 2:12 PM
 */
public final class GitUserConversionUtils {

    private GitUserConversionUtils() {
    }

    public static User convertToUser(GitUser gitUser, List<String> roles) {
        return new User(gitUser.getEmail(), null, roles);
    }

    public static GitUser convertToGitUser(GHUser ghUser) {
        try {
            GitUser gitUser = new GitUser();
            gitUser.setEmail(ghUser.getEmail());
            gitUser.setLogin(ghUser.getLogin());
            gitUser.setCompany(ghUser.getCompany());
            gitUser.setName(ghUser.getName());
            gitUser.setFollowers(ghUser.getFollowersCount());
            return gitUser;
        } catch (IOException e) {
            return new GitUser();
        }
    }

    public static List<GitUser> convertUsers(GHPersonSet<GHUser> users) {
        return Optional.ofNullable(users)
                .orElse((GHPersonSet<GHUser>) Collections.EMPTY_LIST)
                .stream()
                .map(GitUserConversionUtils::convertToGitUser)
                .collect(Collectors.toList());
    }

}

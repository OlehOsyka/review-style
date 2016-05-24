package com.rs.git.service;

import com.rs.core.commons.dto.auth.User;
import com.rs.core.service.BaseService;
import com.rs.git.commons.entity.GitUser;

import java.util.List;

/**
 * Author: Oleh Osyka
 * Date: 5/24/2016
 * Time: 1:56 PM
 */
public interface IGitUserService extends BaseService<GitUser, String> {

    List<GitUser> getRepoContributors(String repoName);

    List<GitUser> getRepoContributors(User user, String repoName);
}

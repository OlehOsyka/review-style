package com.rs.git.service.impl;

import com.rs.core.commons.dto.auth.User;
import com.rs.core.exception.RestException;
import com.rs.git.commons.entity.GitUser;
import com.rs.git.persistence.dao.IGitUserRepository;
import com.rs.git.service.IGitUserService;
import org.kohsuke.github.GHPersonSet;
import org.kohsuke.github.GHRepository;
import org.kohsuke.github.GHUser;
import org.kohsuke.github.GitHub;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

import static com.rs.core.api.ApiErrorCodes.CONNECT_FAILED;
import static com.rs.core.api.ApiErrorCodes.GET_CONTRIBUTORS_FAILED;
import static com.rs.git.commons.utils.GitUserConversionUtils.convertUsers;
import static org.springframework.http.HttpStatus.INTERNAL_SERVER_ERROR;

/**
 * Author: Oleh Osyka
 * Date: 5/24/2016
 * Time: 1:56 PM
 */
@Service
public class GitUserService implements IGitUserService {

    private static final Logger LOGGER = LoggerFactory.getLogger(GitUserService.class);

    @Autowired
    private IGitUserRepository userRepository;

    @Override
    public List<GitUser> getRepoContributors(String repoName) {
        try {
            GitHub github = GitHub.connectAnonymously();
            return convertUsers(getRepoContributors(github, repoName));
        } catch (IOException e) {
            String message = "Can't connect for repository " + repoName;
            LOGGER.error(message, e);
            throw new RestException(message + e.getMessage(), INTERNAL_SERVER_ERROR.value(), CONNECT_FAILED);
        }
    }

    @Override
    public List<GitUser> getRepoContributors(User user, String repoName) {
        try {
            GitHub github = GitHub.connectUsingPassword(user.getEmail(), user.getPassword());
            return convertUsers(getRepoContributors(github, repoName));
        } catch (IOException e) {
            String message = "Can't connect for repository " + repoName;
            LOGGER.error(message, e);
            throw new RestException(message + e.getMessage(), INTERNAL_SERVER_ERROR.value(), CONNECT_FAILED);
        }
    }

    private GHPersonSet<GHUser> getRepoContributors(GitHub github, String repoName) {
        try {
            GHRepository repository = github.getRepository(repoName);
            return repository.getCollaborators();
        } catch (IOException e) {
            String message = "Can't get contributors for repository " + repoName;
            LOGGER.error(message, e);
            throw new RestException(message + e.getMessage(), INTERNAL_SERVER_ERROR.value(), GET_CONTRIBUTORS_FAILED);
        }
    }

    @Override
    public List<GitUser> getAll() {
        return userRepository.getAll();
    }

    @Override
    public GitUser get(String s) {
        return userRepository.get(s);
    }

    @Override
    public void add(GitUser gitUser) {
        userRepository.add(gitUser);
    }

    @Override
    public void delete(GitUser gitUser) {
        userRepository.delete(gitUser);
    }

    @Override
    public void update(GitUser gitUser) {
        userRepository.update(gitUser);
    }
}

package com.rs.git.service.impl;

import com.rs.core.commons.dto.git.Tree;
import com.rs.core.exception.RestException;
import com.rs.git.service.IGitRepositoryService;
import org.apache.commons.io.FileUtils;
import org.eclipse.jgit.api.Git;
import org.eclipse.jgit.api.errors.GitAPIException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

import static com.rs.core.api.ApiErrorCodes.DOWNLOAD_REPOSITORY_FAILED;
import static org.springframework.http.HttpStatus.INTERNAL_SERVER_ERROR;

/**
 * Author: Oleh Osyka
 * Date: 5/24/2016
 * Time: 12:05 PM
 */
@Service
public class GitRepositoryService implements IGitRepositoryService {

    private static final Logger LOGGER = LoggerFactory.getLogger(GitRepositoryService.class);

    @Value("${git.directory}")
    private String gitRepositoryDirectory;
    private File gitDirectory;

    @PostConstruct
    private void initDir() throws IOException {
        gitDirectory = new File(gitRepositoryDirectory);
        FileUtils.forceMkdir(gitDirectory);
    }

    @Override
    public void downloadRepo(String address, String projectName) {
        gitDirectory = new File(gitRepositoryDirectory + File.separator + projectName);
        try {
            if (gitDirectory.list().length > 0) {
                // empty old directory
                FileUtils.forceDelete(gitDirectory);
            }
            // remake directories
            FileUtils.forceMkdir(gitDirectory);
        } catch (IOException e) {
            String message = "Can't make directory to download repository for " + address;
            LOGGER.error(message, e);
            throw new RestException(message + e.getMessage(), INTERNAL_SERVER_ERROR.value(), DOWNLOAD_REPOSITORY_FAILED);
        }

        LOGGER.info("Cloning from " + address + " to " + gitRepositoryDirectory);
        try (Git result = Git.cloneRepository()
                .setURI(address)
                .setDirectory(gitDirectory)
                .call()) {
            // Note: the call() returns an opened repository already which needs to be closed to avoid file handle leaks!
            LOGGER.info("Having repository: " + result.getRepository().getDirectory());
        } catch (GitAPIException e) {
            String message = "Can't download repository for " + address;
            LOGGER.error(message, e);
            throw new RestException(message + e.getMessage(), INTERNAL_SERVER_ERROR.value(), DOWNLOAD_REPOSITORY_FAILED);
        }
    }

    @Override
    public List<Tree> getProjectTree(String projectName) {
        File f = new File(gitRepositoryDirectory + File.separator + projectName);
        return addNewLevel(Arrays.stream(f.list()).collect(Collectors.toList()));
    }

    @Override
    public File getFile(String path) {
        return new File(path);
    }

    private List<Tree> addNewLevel(List<String> currentFiles) {
        List<Tree> tree = new LinkedList<>();
        for (String s : currentFiles) {
            File f = new File(s);
            if (f.isDirectory()) {
                Tree treeNode = convertToTree(f);
                treeNode.setChildren(addNewLevel(Arrays.stream(f.list()).collect(Collectors.toList())));
                tree.add(treeNode);
            } else {
                tree.add(convertToTree(f));
            }
        }
        return tree;
    }

    private Tree convertToTree(File file) {
        Tree tree = new Tree();
        tree.setFolder(file.isDirectory());
        tree.setTitle(file.getName());
        return tree;
    }

}

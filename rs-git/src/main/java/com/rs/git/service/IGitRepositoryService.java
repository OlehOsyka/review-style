package com.rs.git.service;

import com.rs.core.commons.dto.git.Tree;

import java.io.File;
import java.util.List;

/**
 * Author: Oleh Osyka
 * Date: 5/24/2016
 * Time: 12:05 PM
 */
public interface IGitRepositoryService {

    void downloadRepo(String address, String projectName);

    List<Tree> getProjectTree(String projectName);

    File getFile(String path);
}

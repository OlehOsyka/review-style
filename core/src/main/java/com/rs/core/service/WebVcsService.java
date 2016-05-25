package com.rs.core.service;

import com.rs.core.commons.dto.git.Tree;

import java.util.List;

/**
 * Author: Oleh Osyka
 * Date: 5/25/2016
 * Time: 12:05 PM
 */
public interface WebVcsService {

    void projectDownload(String address, String projectName);

    List<Tree> projectTree(String projectName);
}

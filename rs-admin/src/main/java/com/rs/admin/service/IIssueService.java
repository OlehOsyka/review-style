package com.rs.admin.service;

import com.rs.admin.commons.entity.Issue;
import com.rs.core.service.BaseService;

import java.util.List;

/**
 * Author: Oleh Osyka
 * Date: 5/23/2016
 * Time: 5:42 PM
 */
public interface IIssueService extends BaseService<Issue, Long> {
    void add(List<Issue> newIssues);
}

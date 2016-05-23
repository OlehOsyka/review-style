package com.rs.admin.service.impl;

import com.rs.admin.commons.entity.Issue;
import com.rs.admin.persistence.dao.IIssueRepository;
import com.rs.admin.service.IIssueService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Author: Oleh Osyka
 * Date: 5/23/2016
 * Time: 5:43 PM
 */
public class IssueService implements IIssueService {

    @Autowired
    private IIssueRepository issueRepository;

    @Override
    public List<Issue> getAll() {
        return issueRepository.getAll();
    }

    @Override
    public Issue get(Long aLong) {
        return issueRepository.get(aLong);
    }

    @Override
    public void add(Issue issue) {
        issueRepository.add(issue);
    }

    @Override
    public void delete(Issue issue) {
        issueRepository.delete(issue);
    }

    @Override
    public void update(Issue issue) {
        issueRepository.update(issue);
    }

    @Override
    public void add(List<Issue> newIssues) {
        for (Issue i : newIssues) {
            add(i);
        }
    }
}

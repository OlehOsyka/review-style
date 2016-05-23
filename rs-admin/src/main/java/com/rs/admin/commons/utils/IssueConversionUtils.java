package com.rs.admin.commons.utils;

import com.rs.admin.commons.entity.Issue;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import static com.rs.admin.commons.utils.UserConversionUtils.convertToUser;

/**
 * Author: Oleh Osyka
 * Date: 5/23/2016
 * Time: 4:01 PM
 */
public final class IssueConversionUtils {

    private IssueConversionUtils() {
    }

    public static Issue convertToIssue(com.rs.core.commons.dto.admin.Issue coreIssue) {
        Issue issue = new Issue();
        issue.setId(coreIssue.getId());
        issue.setAssigned(convertToUser(coreIssue.getAssigned()));
        issue.setLineFrom(coreIssue.getLineFrom());
        issue.setLineTo(coreIssue.getLineTo());
        issue.setReviwed(coreIssue.getReviewed());
        return issue;
    }

    public static List<Issue> convertToIssues(Collection<com.rs.core.commons.dto.admin.Issue> coreIssues) {
        return coreIssues.stream()
                .map(IssueConversionUtils::convertToIssue)
                .collect(Collectors.toList());
    }

}

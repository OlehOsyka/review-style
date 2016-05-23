package com.rs.core.commons.dto.admin;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.google.common.collect.Lists;
import com.google.common.collect.Sets;
import com.rs.core.commons.dto.auth.User;

import java.util.List;
import java.util.Set;

/**
 * Author: Oleh Osyka
 * Date: 5/23/2016
 * Time: 3:26 PM
 */
@JsonInclude(JsonInclude.Include.NON_EMPTY)
@JsonIgnoreProperties(ignoreUnknown = true)
public class Project {

    private Long id;
    private String name;
    private String description;
    private User owner;
    private String vcsAdress;
    private Set<User> participants = Sets.newHashSet();
    private List<Issue> issues = Lists.newArrayList();


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public User getOwner() {
        return owner;
    }

    public void setOwner(User owner) {
        this.owner = owner;
    }

    public String getVcsAdress() {
        return vcsAdress;
    }

    public void setVcsAdress(String vcsAdress) {
        this.vcsAdress = vcsAdress;
    }

    public Set<User> getParticipants() {
        return participants;
    }

    public void setParticipants(Set<User> participants) {
        this.participants = participants;
    }

    public List<Issue> getIssues() {
        return issues;
    }

    public void setIssues(List<Issue> issues) {
        this.issues = issues;
    }
}

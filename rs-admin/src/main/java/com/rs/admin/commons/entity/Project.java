package com.rs.admin.commons.entity;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import com.google.common.collect.Lists;
import com.google.common.collect.Sets;
import org.hibernate.validator.constraints.NotBlank;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;
import java.util.Set;

import static javax.persistence.GenerationType.IDENTITY;

/**
 * Author: Oleh Osyka
 * Date: 5/20/2016
 * Time: 3:31 PM
 */
@Entity
@Table(name = "projects")
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class Project {

    private Long id;
    private String name;
    private String description;
    private User owner;
    private String vcsAdress;
    private Set<User> participants = Sets.newHashSet();
    private List<Issue> issues = Lists.newArrayList();

    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(unique = true, nullable = false)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Column(nullable = false)
    @NotBlank(message = "Project name is required! ")
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

    @Column(nullable = false, unique = true)
    @NotBlank(message = "Project name is required! ")
    public String getVcsAdress() {
        return vcsAdress;
    }

    public void setVcsAdress(String vcsAdress) {
        this.vcsAdress = vcsAdress;
    }

    @ManyToOne
    @JoinColumn(name = "owner",
            referencedColumnName = "email",
            nullable = false)
    @NotNull(message = "Owner is required! ")
    public User getOwner() {
        return owner;
    }

    public void setOwner(User owner) {
        this.owner = owner;
    }

    @ManyToMany
    @JoinTable(name = "participant",
            joinColumns = {@JoinColumn(name = "projects_id", nullable = false)},
            inverseJoinColumns = {@JoinColumn(name = "users_email", nullable = false)})
    @Size(min = 1, message = "At least one participant is required! ")
    public Set<User> getParticipants() {
        return participants;
    }

    public void setParticipants(Set<User> participants) {
        this.participants = participants;
    }

    @OneToMany(mappedBy = "project")
    public List<Issue> getIssues() {
        return issues;
    }

    public void setIssues(List<Issue> issues) {
        this.issues = issues;
    }
}
